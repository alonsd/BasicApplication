package com.basicapplication.data.repository

import android.util.Log
import com.basicapplication.data.source.local.source.LocalDataSource
import com.basicapplication.data.source.remote.source.RemoteDataSource
import com.haroldadmin.cnradapter.NetworkResponse

class MainRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {

    suspend fun getDataFromApi() {
        when (val dataFromPath = remoteDataSource.getDataFromPath()) {
            is NetworkResponse.Success -> {
                Log.d("getDataFromApi", dataFromPath.body.toString())
            }
            is NetworkResponse.ServerError -> {
                Log.d("getDataFromApi", dataFromPath.body?.message.toString())
            }
            is NetworkResponse.NetworkError -> {
                Log.d("getDataFromApi", dataFromPath.error.message.toString())
            }
            is NetworkResponse.UnknownError -> {
                Log.d("getDataFromApi", dataFromPath.error.message.toString())
            }
        }
    }

    suspend fun getDataFromLocal() = localDataSource.getBasicApplicationModel()

}

