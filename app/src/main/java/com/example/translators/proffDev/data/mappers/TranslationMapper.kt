package com.example.translators.proffDev.data.mappers

import com.example.translators.proffDev.data.model.TranslationResponse
import com.example.translators.proffDev.domain.model.search.Translation


class TranslationMapper {

    fun toDomain(translationResponse: TranslationResponse): Translation =
        Translation.of(translationResponse.text)
}