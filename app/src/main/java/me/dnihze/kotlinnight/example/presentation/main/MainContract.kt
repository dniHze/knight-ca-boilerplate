package me.dnihze.kotlinnight.example.presentation.main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import me.dnihze.kotlinnight.example.domain.CatFact

interface MainContract {

    interface Presenter {
        fun swapLike(fact: CatFact)
    }

    interface View: MvpView {
        @StateStrategyType(AddToEndSingleStrategy::class)
        fun set(model: MainModel)
    }
}