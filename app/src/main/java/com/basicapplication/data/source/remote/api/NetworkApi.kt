package com.basicapplication.data.source.remote.api

import com.basicapplication.model.ErrorResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET

interface NetworkApi {

    @GET("/raw/8wJzytQX")
    suspend fun getDataFromPath() : NetworkResponse<Any, ErrorResponse>
}