package com.example.translators.presentation.data.mappers

import com.example.translators.presentation.data.model.TranslationResponse
import com.example.translators.presentation.domain.model.Translation


class TranslationMapper {

    fun toDomain(translationResponse: TranslationResponse): Translation =
        Translation.of(translationResponse.text)
}