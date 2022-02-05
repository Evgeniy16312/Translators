package com.example.translators.proffDev.data.repository

import com.example.translators.proffDev.data.mappers.HistoryMapper
import com.example.translators.proffDev.data.room.HistoryDao
import com.example.translators.proffDev.domain.model.history.History
import com.example.translators.proffDev.domain.repositories.RepositoryLocal
import com.example.translators.proffDev.util.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext

class RepositoryLocalImpl(
    private val historyDao: HistoryDao,
    private val historyMapper: HistoryMapper,
    private val dispatcherProvider: DispatcherProvider
) : RepositoryLocal<History> {
    override suspend fun getData(): Flow<List<History>> = flowOf(
        historyDao.all().map { historyMapper.toDomain(it) }
    )

    override suspend fun clear() = withContext(dispatcherProvider.io()) {
        historyDao.clear()
    }

    override suspend fun saveToDatabase(data: History) = withContext(dispatcherProvider.io()) {
        historyDao.insert(historyMapper.toData(data))
    }
}


