package com.example.translators.di

import com.example.translators.data.api.TranslatorAPI
import com.example.translators.data.mappers.DataModelMapper
import com.example.translators.data.mappers.MeaningsMapper
import com.example.translators.data.mappers.TranslationMapper
import com.example.translators.data.repository.RepositoryImpl
import com.example.translators.domain.model.DataModel
import com.example.translators.domain.repository.Repository
import com.example.translators.presentation.search.SearchViewModel
import com.example.translators.util.DefaultDispatcherProvider
import com.example.translators.util.DispatcherProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val application = module {

    factory { TranslationMapper() }
    factory { MeaningsMapper(get()) }
    factory { DataModelMapper(get()) }
    single { TranslatorAPI.create() }
    single<Repository<DataModel>> { RepositoryImpl(get(), get()) }
    factory<DispatcherProvider> { DefaultDispatcherProvider() }
}

val searchScreen = module {

    viewModel { SearchViewModel(get(), get()) }
}