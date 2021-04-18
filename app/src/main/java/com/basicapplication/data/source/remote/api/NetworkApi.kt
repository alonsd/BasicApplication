package com.basicapplication.data.source.remote.api

import com.basicapplication.model.models.BasicApplicationModel
import com.basicapplication.model.models.ServerErrorResponseModel
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface NetworkApi {

    @GET("/raw/8wJzytQX")
    suspend fun getDataFromPath() : NetworkResponse<BasicApplicationModel, ServerErrorResponseModel>
}