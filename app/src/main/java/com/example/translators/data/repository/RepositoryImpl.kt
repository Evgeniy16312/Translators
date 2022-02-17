package com.example.translators.data.repository

import com.example.translators.data.api.TranslatorAPI
import com.example.translators.data.mappers.DataModelMapper
import com.example.translators.domain.model.DataModel
import com.example.translators.domain.repository.Repository
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