package com.example.translators.di

import androidx.room.Room
import com.example.translators.data.api.TranslatorAPI
import com.example.translators.data.mappers.DataModelMapper
import com.example.translators.data.mappers.MeaningsMapper
import com.example.translators.data.mappers.TranslationMapper
import com.example.translators.data.repository.RepositoryImpl
import com.example.translators.data.room.HistoryDatabase
import com.example.translators.domain.model.DataModel
import com.example.translators.domain.repository.Repository
import com.example.translators.presentation.search.SearchViewModel
import com.example.translators.util.DefaultDispatcherProvider
import com.example.translators.util.DispatcherProvider
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@FlowPreview
val application = module {

    single { Room.databaseBuilder(get(), HistoryDatabase::class.java, "HistoryDB").build() }
    single { get<HistoryDatabase>().historyDao() }
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

val historyScreen = module {

}