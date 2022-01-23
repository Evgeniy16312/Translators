package com.example.translators.presentation.data.mappers

import com.example.translators.presentation.data.model.MeaningsResponse
import com.example.translators.presentation.domain.model.Meanings
import javax.inject.Inject

class MeaningsMapper @Inject constructor(private val translationMapper: TranslationMapper) {

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