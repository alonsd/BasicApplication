package com.basicapplication.service_locator

import com.basicapplication.network.repository.MainRepository
import org.koin.dsl.module


val repositoryModule = module {

    single { MainRepository(get(), get()) }
}