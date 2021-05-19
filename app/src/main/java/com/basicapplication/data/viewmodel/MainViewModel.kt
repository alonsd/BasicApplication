package com.basicapplication.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basicapplication.data.repository.MainRepository
import com.basicapplication.model.models.BasicApplicationModel
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val mutableDataFlow = MutableStateFlow<MainViewModelActions>(MainViewModelActions.EmptyValue)
    val dataFlow = mutableDataFlow.asStateFlow()

    fun getBasicApplicationDataTypeOne() = viewModelScope.launch(Dispatchers.IO) {
        when (val response = mainRepository.getDataFromApi()) {
            is NetworkResponse.Success -> {
                mutableDataFlow.emit(MainViewModelActions.ShowDataTypeOne(response.body.numbers))
            }

            is NetworkResponse.Error -> {
                response.error.message?.let { message ->
                    mutableDataFlow.emit(MainViewModelActions.ShowGeneralError(message))
                }
            }
        }
    }

    sealed class MainViewModelActions {
        data class ShowDataTypeOne(val modelsList: List<BasicApplicationModel.Number>) : MainViewModelActions()
        data class ShowGeneralError(val errorMessage: String) : MainViewModelActions()
        object EmptyValue : MainViewModelActions()
    }
}