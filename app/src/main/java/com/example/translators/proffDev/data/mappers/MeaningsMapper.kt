package com.example.translators.proffDev.data.mappers

import com.example.translators.proffDev.data.model.MeaningsResponse
import com.example.translators.proffDev.domain.model.search.Meanings

class MeaningsMapper(private val translationMapper: TranslationMapper) {

    private fun toDomain(meaningsResponse: MeaningsResponse): Meanings {

        requireNotNull(meaningsResponse.translation)

        return Meanings.of(
            translationMapper.toDomain(meaningsResponse.translation),
            meaningsResponse.imageUrl,
            meaningsResponse.soundUrl
        )
    }

    fun toDomain(meaningsResponses: List<MeaningsResponse>): List<Meanings> =
        meaningsResponses.map { toDomain(it) }

}