package com.basicapplication.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.basicapplication.network.repository.MainRepository
import com.basicapplication.utils.network.ResponseHandler

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val apiInfo : LiveData<ResponseHandler.Resource<Any>> = liveData {
        emit(ResponseHandler.Resource.loading(null))
        emit(mainRepository.getSomethingFromPath())
    }
}