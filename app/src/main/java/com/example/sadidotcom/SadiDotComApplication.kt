package com.example.sadidotcom

import android.app.Application
import com.example.sadidotcom.koin.appModule
import com.example.sadidotcom.koin.dataBaseModule
import com.example.sadidotcom.koin.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SadiDotComApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@SadiDotComApplication)
            modules(listOf(appModule, retrofitModule, dataBaseModule))
        }
    }
}