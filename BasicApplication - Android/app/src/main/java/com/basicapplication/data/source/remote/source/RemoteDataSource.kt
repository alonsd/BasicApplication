package com.basicapplication.data.source.remote.source

import com.basicapplication.data.source.remote.api.NetworkApi

class RemoteDataSource(private val networkApi: NetworkApi) {

    suspend fun getDataFromApi() = networkApi.getDataFromApi()


}