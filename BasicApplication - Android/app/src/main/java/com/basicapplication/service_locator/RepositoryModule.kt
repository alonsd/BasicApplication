package com.basicapplication.service_locator

import com.basicapplication.data.repository.Repository
import org.koin.dsl.module


val repositoryModule = module {

    single { Repository(get(), get()) }
}