package com.example.translators.presentation.di

import com.example.translators.presentation.data.api.TranslatorAPI
import dagger.Module
import dagger.Provides


@Module
class NetworkModule {
    @Provides
    fun provideTranslatorAPI(): TranslatorAPI = TranslatorAPI.create()
}