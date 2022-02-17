package com.example.translators.presentation.application


import android.app.Application
import com.example.translators.presentation.di.AppComponent
import com.example.translators.presentation.di.DaggerAppComponent

class App : Application() {

    companion object {
        val component: AppComponent by lazy {
            DaggerAppComponent.builder().build()
        }
    }
}