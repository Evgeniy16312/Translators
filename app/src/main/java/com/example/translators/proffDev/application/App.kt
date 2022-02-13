package com.example.translators.proffDev.application

import android.app.Application
import com.example.translators.proffDev.di.application
import com.example.translators.proffDev.di.historyScreen
import com.example.translators.proffDev.di.searchScreen
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


@FlowPreview
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, searchScreen, historyScreen))
        }
    }

}