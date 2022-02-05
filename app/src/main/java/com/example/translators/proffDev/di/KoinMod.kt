package com.example.translators.proffDev.di

import androidx.room.Room
import com.example.translators.proffDev.data.api.TranslatorApi
import com.example.translators.proffDev.data.mappers.DataModelMapper
import com.example.translators.proffDev.data.mappers.HistoryMapper
import com.example.translators.proffDev.data.mappers.MeaningsMapper
import com.example.translators.proffDev.data.mappers.TranslationMapper
import com.example.translators.proffDev.data.repository.RepositoryImpl
import com.example.translators.proffDev.data.repository.RepositoryLocalImpl
import com.example.translators.proffDev.data.room.HistoryDatabase
import com.example.translators.proffDev.domain.model.history.History
import com.example.translators.proffDev.domain.model.search.DataModel
import com.example.translators.proffDev.domain.repositories.Repository
import com.example.translators.proffDev.domain.repositories.RepositoryLocal
import com.example.translators.proffDev.presentation.history.HistoryViewModel
import com.example.translators.proffDev.presentation.history.mappers.UiHistoryMapper
import com.example.translators.proffDev.presentation.search.SearchViewModel
import com.example.translators.proffDev.util.DefaultDispatcherProvider
import com.example.translators.proffDev.util.DispatcherProvider
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


@FlowPreview
val application = module {
    single { Room.databaseBuilder(get(), HistoryDatabase::class.java, "HistoryDB").build() }
    single { get<HistoryDatabase>().historyDao() }
    factory { UiHistoryMapper() }
    factory { TranslationMapper() }
    factory { MeaningsMapper(get()) }
    factory { DataModelMapper(get()) }
    single { TranslatorApi.create() }
    single<Repository<DataModel>> { RepositoryImpl(get(), get()) }
    factory<DispatcherProvider> { DefaultDispatcherProvider() }
}

val searchScreen = module {
    viewModel { SearchViewModel(get(), get(), get(), get()) }
}

val historyScreen = module {
    single<RepositoryLocal<History>> { RepositoryLocalImpl(get(), get(), get()) }
    single { HistoryMapper() }
    viewModel { HistoryViewModel(get(), get()) }
}



