package com.example.translators.presentation.di

import com.example.translators.presentation.data.api.TranslatorAPI
import com.example.translators.presentation.data.mappers.DataModelMapper
import com.example.translators.presentation.data.mappers.MeaningsMapper
import com.example.translators.presentation.data.mappers.TranslationMapper
import com.example.translators.presentation.data.repository.RepositoryImpl
import com.example.translators.presentation.domain.model.DataModel
import com.example.translators.presentation.domain.repositories.Repository
import com.example.translators.presentation.presentation.search.SearchViewModel
import com.example.translators.presentation.util.DefaultDispatcherProvider
import com.example.translators.presentation.util.DispatcherProvider
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