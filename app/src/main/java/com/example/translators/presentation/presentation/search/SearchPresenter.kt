package com.example.translators.presentation.presentation.search

import com.example.translators.presentation.domain.model.DataModel
import com.example.translators.presentation.domain.repositories.Repository
import com.example.translators.presentation.util.SchedulersProvider
import io.reactivex.rxjava3.disposables.CompositeDisposable

class SearchPresenter(
    private val repository: Repository<DataModel>,
    private val schedulersProvider: SchedulersProvider
) : SearchContract.Presenter<SearchContract.View> {

    private val compositeDisposable = CompositeDisposable()

    private var view: SearchContract.View? = null

    override fun attachView(view: SearchFragment) {
        this.view = view
        view.renderData(SearchViewState.CallToAction)
    }

    override fun detachView() {
        view = null
        compositeDisposable.dispose()
    }

    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(repository.getData(word, isOnline)
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.main())
            .doOnSubscribe { view?.renderData(SearchViewState.Loading) }
            .subscribe({
                if (it.isEmpty()) {
                    view?.renderData(SearchViewState.EmptyResult)
                } else {
                    view?.renderData(SearchViewState.Success(it))
                }
            }, {
                view?.renderData(SearchViewState.Error(it))
            })
        )
    }
}