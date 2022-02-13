package com.example.translators.proffDev.domain.repositories

import kotlinx.coroutines.flow.Flow

interface RepositoryLocal<T : Any> {
    suspend fun getData(): Flow<List<T>>
    suspend fun saveToDatabase(data: T)
    suspend fun clear()
}