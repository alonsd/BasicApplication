package com.basicapplication.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basicapplication.data.repository.MainRepository
import com.basicapplication.model.models.BasicApplicationModel
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val mutableDataFlow = MutableStateFlow<MainFragmentActions>(MainFragmentActions.EmptyValue)
    val dataFlow = mutableDataFlow.asStateFlow()

    fun getBasicApplicationDataTypeOne() = viewModelScope.launch {
        when (val response = mainRepository.getDataFromApi()) {
            is NetworkResponse.Success -> {
                mutableDataFlow.emit(MainFragmentActions.ShowDataTypeOne(response.body.numbers))
            }
            is NetworkResponse.ServerError -> {
               response.body?.let { errorModel ->
                   mutableDataFlow.emit(MainFragmentActions.ShowGeneralError(errorModel.message))
               }
            }
            is NetworkResponse.NetworkError-> {
                response.error.message?.let { exceptionMessage ->
                    mutableDataFlow.emit(MainFragmentActions.ShowGeneralError(exceptionMessage))
                }
            }
            is NetworkResponse.UnknownError -> {
                response.error.message?.let { exceptionMessage ->
                    mutableDataFlow.emit(MainFragmentActions.ShowGeneralError(exceptionMessage))
                }
            }
        }
    }


    sealed class MainFragmentActions {
        data class ShowDataTypeOne(val modelsList: List<BasicApplicationModel.Number>) : MainFragmentActions()
        data class ShowGeneralError(val errorMessage: String) : MainFragmentActions()
        object EmptyValue : MainFragmentActions()
    }
}