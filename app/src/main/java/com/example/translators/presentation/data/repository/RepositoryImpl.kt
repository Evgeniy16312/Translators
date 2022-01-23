package com.example.translators.presentation.data.repository

import com.example.translators.presentation.data.api.TranslatorAPI
import com.example.translators.presentation.data.mappers.DataModelMapper
import com.example.translators.presentation.domain.model.DataModel
import com.example.translators.presentation.domain.repositories.Repository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


@FlowPreview
class RepositoryImpl(
    private val translatorApi: TranslatorAPI,
    private val dataModelMapper: DataModelMapper
) : Repository<DataModel> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): Flow<List<DataModel>> {
        return if (fromRemoteSource) {
            flowOf(
                translatorApi.searchAsync(word).await()
                    .filter { !it.meanings.isNullOrEmpty() }
                    .map { dataModelMapper.toDomain(it) }
            )
        } else {
            TODO("Room will be here")
        }
    }
}