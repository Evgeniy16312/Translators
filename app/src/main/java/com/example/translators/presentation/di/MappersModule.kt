package com.example.translators.presentation.di

import com.example.translators.presentation.data.mappers.DataModelMapper
import com.example.translators.presentation.data.mappers.MeaningsMapper
import com.example.translators.presentation.data.mappers.TranslationMapper
import dagger.Module
import dagger.Provides

@Module
class MappersModule {

    @Provides
    fun provideTranslationMapper(): TranslationMapper = TranslationMapper()

    @Provides
    fun provideMeaningsMapper(translationMapper: TranslationMapper): MeaningsMapper =
        MeaningsMapper(translationMapper)

    @Provides
    fun provideDataModelMapper(meaningsMapper: MeaningsMapper): DataModelMapper =
        DataModelMapper(meaningsMapper)

}