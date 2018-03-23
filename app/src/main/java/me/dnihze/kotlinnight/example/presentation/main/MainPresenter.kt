package me.dnihze.kotlinnight.example.presentation.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.channels.map
import kotlinx.coroutines.experimental.launch
import me.dnihze.kotlinnight.example.domain.CatFact
import me.dnihze.kotlinnight.example.domain.interactor.MainInteractor
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
        private val interactor: MainInteractor
) : MvpPresenter<MainContract.View>(), MainContract.Presenter {

    private var reactiveJob: Job? = null

    override fun onFirstViewAttach() {
        val model = MainModel(true)
        viewState.set(model)

        reactiveJob = launch(UI) {
            interactor.factsChannel
                    .openSubscription()
                    .map {
                        MainModel(false, data = it)
                    }
                    .consumeEach {
                        viewState.set(it)
                    }
        }

        launch(UI) {
            try {
                interactor.loadData()
            } catch (e: Exception) {
                val errorModel = MainModel(false, e)
                viewState.set(errorModel)
            }
        }
    }

    override fun onDestroy() {
        reactiveJob?.cancel()
    }

    override fun swapLike(fact: CatFact) {
        launch {
            interactor.swapLike(fact)
        }
    }

}