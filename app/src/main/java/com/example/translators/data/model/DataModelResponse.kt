package com.example.translators.data.model

import com.google.gson.annotations.SerializedName

data class DataModelResponse(
    @field:SerializedName("text") val text: String?,
    @field:SerializedName("meanings") val meanings: List<MeaningsResponse>?
)