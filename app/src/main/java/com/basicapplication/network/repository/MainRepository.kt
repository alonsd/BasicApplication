package com.basicapplication.network.repository

import com.basicapplication.network.api.NetworkApi
import com.basicapplication.utils.network.Resource
import retrofit2.HttpException
import java.lang.Exception

class MainRepository(private val networkApi: NetworkApi) {

    suspend fun getSomethingFromPath(): Resource<Any> {
        return try {
            Resource.Completed(networkApi.getSomethingFromPath())
        } catch (e: Exception) {
            Resource.Error(e as HttpException)
        }
    }
}

