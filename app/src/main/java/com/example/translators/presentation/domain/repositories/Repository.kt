package com.example.translators.presentation.domain.repositories

import com.example.translators.presentation.domain.model.DataModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface Repository<T : Any> {
    fun getData(word: String, fromRemoteSource: Boolean): Single<List<DataModel>>
}