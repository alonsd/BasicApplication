package com.basicapplication.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basicapplication.data.repository.MainRepository
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val dataFlow = MutableStateFlow<MainFragmentActions>(MainFragmentActions.EmptyValue)

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        when (val data = mainRepository.getDataFromApi()) {
            is NetworkResponse.Success -> dataFlow.value = MainFragmentActions.ShowData(data)
            is NetworkResponse.ServerError -> dataFlow.value = MainFragmentActions.ShowError(data.body?.message!!)
            is NetworkResponse.NetworkError -> dataFlow.value = MainFragmentActions.ShowError(data.error.message!!)
            is NetworkResponse.UnknownError -> dataFlow.value = MainFragmentActions.ShowError(data.error.message!!)
        }
    }

    sealed class MainFragmentActions {
        data class ShowData(val data: Any) : MainFragmentActions()
        data class ShowError(val errorMessage: String) : MainFragmentActions()
        object EmptyValue : MainFragmentActions()
    }
}