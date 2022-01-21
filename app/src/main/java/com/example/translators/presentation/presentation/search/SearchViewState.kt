package com.example.translators.presentation.presentation.search

import com.example.translators.presentation.domain.model.DataModel

sealed class SearchViewState {

    data class Success(val data: List<DataModel>) : SearchViewState()

    data class Error(val error: Throwable) : SearchViewState()

    object Loading : SearchViewState()

    object EmptyResult : SearchViewState()

    object CallToAction : SearchViewState()

}