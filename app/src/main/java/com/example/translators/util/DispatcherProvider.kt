package com.example.translators.util

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {

    fun io(): CoroutineDispatcher

    fun main(): CoroutineDispatcher

}