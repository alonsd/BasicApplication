package com.basicapplication.data.source.remote.api

import retrofit2.http.GET

interface NetworkApi {

    @GET("/raw/8wJzytQX")
    suspend fun getDataFromPath() : Any
}