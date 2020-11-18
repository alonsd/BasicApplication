package com.basicapplication.data.api

import retrofit2.http.GET

interface NetworkApi {

    @GET("/raw/8wJzytQX")
    suspend fun getSomethingFromPath() : Any
}