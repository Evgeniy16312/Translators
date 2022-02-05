package com.example.translators.proffDev.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translators.proffDev.domain.model.history.History
import com.example.translators.proffDev.domain.model.search.DataModel
import com.example.translators.proffDev.domain.repositories.Repository
import com.example.translators.proffDev.domain.repositories.RepositoryLocal
import com.example.translators.proffDev.presentation.history.mappers.UiHistoryMapper
import com.example.translators.proffDev.util.DispatcherProvider
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class SearchViewModel(
    private val repository: Repository<DataModel>,
    private val localRepository: RepositoryLocal<History>,
    private val dispatcherProvider: DispatcherProvider,
    private val uiHistoryMapper: UiHistoryMapper
) : ViewModel() {

    private val _viewState = MutableStateFlow<SearchViewState>(SearchViewState.CallToAction)

    val viewState: StateFlow<SearchViewState> get() = _viewState.asStateFlow()

    fun getData(word: String) {

        cancelJob()

        viewModelScope.launch {

            setLoadingState()

            repository.getData(word)
                .flowOn(dispatcherProvider.io())
                .catch { handleError(it) }
                .collect {
                    if (it.isEmpty()) setEmptyResultState()
                    else setSuccessState(it, word)
                }
        }
    }

    private suspend fun setSuccessState(data: List<DataModel>, word: String) {
        localRepository.saveToDatabase(uiHistoryMapper.toDomain(word))
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