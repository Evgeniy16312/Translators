package com.example.translators.data.mappers

import com.example.translators.data.model.TranslationResponse
import com.example.translators.domain.model.Translation


class TranslationMapper {

    fun toDomain(translationResponse: TranslationResponse): Translation =
        Translation.of(translationResponse.text)
}