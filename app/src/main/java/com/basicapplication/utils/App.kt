package com.basicapplication.utils

import android.app.Application
import android.content.Context
import com.basicapplication.service_locator.networkModule
import com.basicapplication.service_locator.repositoryModule
import com.basicapplication.service_locator.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(networkModule, repositoryModule, viewModelModule)
        }
    }
}