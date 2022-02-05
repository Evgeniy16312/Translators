package com.example.translators.proffDev.domain.model.history

data class History(
    val timestamp: Long,
    val word: String
) {
    companion object {
        fun of(
            timestamp: Long,
            word: String
        ): History =
            History(timestamp, word)
    }
}