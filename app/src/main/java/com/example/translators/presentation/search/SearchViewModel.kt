package com.example.translators.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translators.domain.model.DataModel
import com.example.translators.domain.repository.Repository
import com.example.translators.util.DispatcherProvider
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class SearchViewModel(
    private val repository: Repository<DataModel>,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

     private val _viewState = MutableStateFlow<SearchViewState>(SearchViewState.CallToAction)

    val viewState: StateFlow<SearchViewState> get() = _viewState.asStateFlow()

    fun getData(word: String, isOnline: Boolean) {

        cancelJob()

        viewModelScope.launch {

            setLoadingState()

            repository.getData(word, isOnline)
                .flowOn(dispatcherProvider.io())
                .catch { handleError(it) }
                .collect {
                    if (it.isEmpty()) setEmptyResultState()
                    else setSuccessState(it)
                }
        }
    }

    private suspend fun setSuccessState(data: List<DataModel>) {
        _viewState.emit(SearchViewState.Success(data))
    }

    private suspend fun setLoadingState() {
        _viewState.emit(SearchViewState.Loading)
    }

    private suspend fun setEmptyResultState() {
        _viewState.emit(SearchViewState.EmptyResult)
    }

    private suspend fun handleError(error: Throwable) {
        _viewState.emit(SearchViewState.Error(error))
    }

    private fun cancelJob() {
        viewModelScope.coroutineContext.cancelChildren()
    }

    override fun onCleared() {
        cancelJob()
    }
}