package com.basicapplication.service_locator

import com.basicapplication.data.source.remote.source.RemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single { RemoteDataSource(get()) }
}