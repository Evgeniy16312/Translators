package com.example.translators.presentation.di

import com.example.translators.presentation.util.SchedulersProvider
import com.example.translators.presentation.util.SchedulersProviderImplementation
import dagger.Module
import dagger.Provides

@Module
class RxModule {

    @Provides
    fun provideSchedulersProvider(): SchedulersProvider =
        SchedulersProviderImplementation()
}