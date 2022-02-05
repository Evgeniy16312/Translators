package com.example.translators.proffDev.util

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {

    fun io(): CoroutineDispatcher

    fun main(): CoroutineDispatcher

}