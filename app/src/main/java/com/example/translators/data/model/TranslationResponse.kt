package com.example.translators.data.model

import com.google.gson.annotations.SerializedName

data class TranslationResponse(
    @field:SerializedName("text") val text: String?
)