package com.basicapplication.service_locator

import com.basicapplication.data.source.local.source.LocalDataSource
import com.basicapplication.database.BasicApplicationDatabase
import org.koin.dsl.module

val localDataSourceModule = module {

    single { LocalDataSource(BasicApplicationDatabase.getInstance().basicApplicationDao()) }

}