package com.basicapplication.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basicapplication.data.repository.MainRepository
import com.basicapplication.model.ServerErrorResponse
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val dataFlow = MutableStateFlow<MainFragmentActions>(MainFragmentActions.EmptyValue)

    fun getBasicApplicationDataTypeOne() = viewModelScope.launch {
        getMainFragmentData { mainRepository.getDataFromApi() }
    }

    private fun <T : Any> getMainFragmentData(predicate: suspend () -> NetworkResponse<T, ServerErrorResponse>) =
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = predicate()) {
                is NetworkResponse.Success -> { sortData(response) }
                is NetworkResponse.ServerError -> dataFlow.value = MainFragmentActions.ShowError(response.body?.message!!)
                is NetworkResponse.NetworkError -> dataFlow.value = MainFragmentActions.ShowError(response.error.message!!)
                is NetworkResponse.UnknownError -> dataFlow.value = MainFragmentActions.ShowError(response.error.message!!)
            }
        }

    private fun <T : Any> sortData(response: NetworkResponse.Success<T>) {
        when (val data = response.body) {
            is String -> {
                dataFlow.value = MainFragmentActions.ShowDataTypeOne(data)
            }
            is Int -> {
                dataFlow.value = MainFragmentActions.ShowDataTypeTwo(data)
            }
        }
    }

    sealed class MainFragmentActions {
        data class ShowDataTypeOne(val data: String) : MainFragmentActions()
        data class ShowDataTypeTwo(val data: Int) : MainFragmentActions()
        data class ShowError(val errorMessage: String) : MainFragmentActions()
        object EmptyValue : MainFragmentActions()
    }
}