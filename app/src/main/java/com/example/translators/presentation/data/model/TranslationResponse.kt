package com.example.translators.presentation.data.model

import com.google.gson.annotations.SerializedName

data class TranslationResponse(
    @field:SerializedName("text") val text: String?
)