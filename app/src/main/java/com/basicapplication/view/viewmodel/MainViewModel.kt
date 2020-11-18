package com.basicapplication.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.basicapplication.data.repository.MainRepository
import com.basicapplication.utils.network.Resource

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val apiData : LiveData<Resource<Any>> = liveData {
        emit(Resource.Loading())
        emit(mainRepository.getDataFromApi())
    }
}