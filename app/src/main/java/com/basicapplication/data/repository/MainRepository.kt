package com.basicapplication.data.repository

import com.basicapplication.data.source.RemoteDataSource

class MainRepository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getDataFromApi() = remoteDataSource.getDataFromPath()
}

