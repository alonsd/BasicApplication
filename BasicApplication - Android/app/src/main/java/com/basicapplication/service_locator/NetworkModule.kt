package com.basicapplication.service_locator

import com.basicapplication.BuildConfig
import com.basicapplication.data.source.remote.api.NetworkApi
import com.basicapplication.data.source.remote.source.RemoteDataSource
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideRetrofit() }
    single { provideApi(get()) }
}

private fun provideRetrofit() =
    Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(NetworkResponseAdapterFactory())
        .client(provideOkHttpClient())
        .build()

private fun provideApi(retrofit: Retrofit): NetworkApi = retrofit.create(NetworkApi::class.java)

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }).build()
}