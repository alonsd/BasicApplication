package com.basicapplication.utils.application

import android.app.Application
import android.content.Context
import com.basicapplication.service_locator.dataModule
import com.basicapplication.service_locator.networkModule
import com.basicapplication.service_locator.repositoryModule
import com.basicapplication.service_locator.viewModelModule
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

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(networkModule, repositoryModule, viewModelModule, dataModule)
        }
    }
}