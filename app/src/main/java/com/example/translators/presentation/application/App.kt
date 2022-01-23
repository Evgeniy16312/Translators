package com.example.translators.presentation.application


import android.app.Application
import com.example.translators.presentation.di.application
import com.example.translators.presentation.di.searchScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        org.koin.core.context.startKoin {
            androidContext(this@App)
            modules(listOf(application, searchScreen))
        }
    }
}