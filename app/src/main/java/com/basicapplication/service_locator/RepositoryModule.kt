package com.basicapplication.service_locator

import com.basicapplication.data.repository.MainRepository
import org.koin.dsl.module


val repositoryModule = module {

    single { MainRepository(get()) }
}