package com.example.translators.proffDev.data.repository

import com.example.translators.proffDev.data.api.TranslatorApi
import com.example.translators.proffDev.data.mappers.DataModelMapper
import com.example.translators.proffDev.domain.model.search.DataModel
import com.example.translators.proffDev.domain.repositories.Repository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@FlowPreview
class RepositoryImpl(
    private val translatorApi: TranslatorApi,
    private val dataModelMapper: DataModelMapper
) : Repository<DataModel> {

    override suspend fun getData(word: String): Flow<List<DataModel>> =
        flowOf(
            translatorApi.searchAsync(word).await()
                .filter { !it.meanings.isNullOrEmpty() }
                .map { dataModelMapper.toDomain(it) }
        )

}
