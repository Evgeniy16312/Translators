package com.example.translators.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataModel(
    val text: String,
    val meanings: List<Meanings>
) : Parcelable {
    companion object {
        fun of(
            text: String?,
            meanings: List<Meanings>
        ): DataModel =
            DataModel(text.orEmpty(), meanings)
    }
}