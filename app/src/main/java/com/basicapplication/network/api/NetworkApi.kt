package com.basicapplication.network.api

import retrofit2.http.GET

interface NetworkApi {

    @GET("/raw/8wJzytQX")
    suspend fun getSomethingFromPath() : Any
}