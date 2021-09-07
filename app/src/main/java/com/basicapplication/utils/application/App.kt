package com.basicapplication.utils.application

import android.app.Application
import android.content.Context
import com.basicapplication.service_locator.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        private var instance: App? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)
//            androidLogger() //Causes bugs with Kotlin 1.5 - check in the future if problem was fixed
            modules(remoteDataSourceModule, localDataSourceModule, repositoryModule, viewModelModule, )
        }
    }
}