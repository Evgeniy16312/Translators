package com.example.translators.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Translation(
    val text: String
) : Parcelable {
    companion object {
        fun of(text: String?): Translation =
            Translation(text.orEmpty())
    }
}