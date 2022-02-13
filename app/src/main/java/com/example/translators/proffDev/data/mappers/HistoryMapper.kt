package com.example.translators.proffDev.data.mappers

import com.example.translators.proffDev.data.room.HistoryEntity
import com.example.translators.proffDev.domain.model.history.History

class HistoryMapper {

    fun toDomain(entity: HistoryEntity): History =
        History.of(
            timestamp = entity.timestamp,
            word = entity.word
        )

    fun toData(history: History): HistoryEntity =
        HistoryEntity(
            word = history.word,
            timestamp = history.timestamp
        )
}