package com.basicapplication.service_locator

import com.basicapplication.data.source.RemoteDataSource
import org.koin.dsl.module

val dataModule = module {

    single { RemoteDataSource(get()) }
}