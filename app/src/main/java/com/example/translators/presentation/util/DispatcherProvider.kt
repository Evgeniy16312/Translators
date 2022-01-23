package com.example.translators.presentation.util

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {

    fun io(): CoroutineDispatcher

    fun main(): CoroutineDispatcher

}