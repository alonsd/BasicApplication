package com.basicapplication.data.source

import com.basicapplication.data.api.NetworkApi
import com.basicapplication.utils.network.Resource
import retrofit2.HttpException
import java.lang.Exception

class RemoteDataSource(private val networkApi : NetworkApi){

    suspend fun getDataFromPath(): Resource<Any> {
        return try {
            Resource.Success(networkApi.getSomethingFromPath())
        } catch (e: Exception) {
            Resource.Exception(e as HttpException)
        }
    }

}