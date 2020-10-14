package com.basicapplication.network.repository

import com.basicapplication.network.api.NetworkApi
import com.basicapplication.utils.network.ResponseHandler
import java.lang.Exception

class MainRepository(private val networkApi: NetworkApi, private val responseHandler: ResponseHandler) {

    suspend fun getSomethingFromPath(): ResponseHandler.Resource<Any> {
        return try {
            responseHandler.handleSuccess(networkApi.getSomethingFromPath())
        } catch (e : Exception) {
            responseHandler.handleException(e)
        }
    }
}

