package com.example.translators.presentation.di

import com.example.translators.presentation.data.api.TranslatorAPI
import com.example.translators.presentation.data.mappers.DataModelMapper
import com.example.translators.presentation.data.repository.RepositoryImpl
import com.example.translators.presentation.domain.model.DataModel
import com.example.translators.presentation.domain.repositories.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
        translatorAPI: TranslatorAPI,
        dataModelMapper: DataModelMapper
    ): Repository<DataModel> =
        RepositoryImpl(translatorAPI, dataModelMapper)
}