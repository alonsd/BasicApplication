package com.basicapplication.data.repository

import com.basicapplication.data.source.local.source.LocalDataSource
import com.basicapplication.data.source.remote.source.RemoteDataSource

class MainRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {

    suspend fun getDataFromApi() = remoteDataSource.getDataFromPath()

    suspend fun getDataFromLocal() = localDataSource.getBasicApplicationModel()

}

