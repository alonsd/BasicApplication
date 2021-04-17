package com.basicapplication.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.basicapplication.data.repository.MainRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getData() = liveData(Dispatchers.IO) {
//        emit(mainRepository.getDataFromLocal())
        emit(mainRepository.getDataFromApi())
    }
}