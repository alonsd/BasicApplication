package com.basicapplication.service_locator

import com.basicapplication.network.api.NetworkApi
import com.basicapplication.utils.Constants.Api.BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideRetrofit() }
    single { provideApi(get()) }
}

private fun provideRetrofit() = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

private fun provideApi(retrofit: Retrofit): NetworkApi = retrofit.create(NetworkApi::class.java)
