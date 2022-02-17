package com.example.translators.presentation.data.repository

import com.example.translators.presentation.data.api.TranslatorAPI
import com.example.translators.presentation.data.mappers.DataModelMapper
import com.example.translators.presentation.domain.model.DataModel
import com.example.translators.presentation.domain.repositories.Repository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val translatorAPI: TranslatorAPI,
    private val dataModelMapper: DataModelMapper
) : Repository<DataModel> {

    override fun getData(word: String, fromRemoteSource: Boolean):  Single<List<DataModel>> {
        return if (fromRemoteSource) {
            translatorAPI.search(word)
                .flatMapObservable { Observable.fromIterable(it) }
                .filter { !it.meanings.isNullOrEmpty() }
                .toList()
                .map { dataModelMapper.toDomain(it) }
        } else {
            TODO("wait db")
        }
    }
}