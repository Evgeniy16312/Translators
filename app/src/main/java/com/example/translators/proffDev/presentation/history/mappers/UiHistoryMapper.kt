package com.example.translators.proffDev.presentation.history.mappers

import com.example.translators.proffDev.domain.model.history.History

class UiHistoryMapper {
    fun toDomain(word: String): History =
        History(
            timestamp = System.currentTimeMillis(),
            word = word
        )
}