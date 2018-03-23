package me.dnihze.kotlinnight.example.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import me.dnihze.kotlinnight.example.App
import me.dnihze.kotlinnight.example.R
import me.dnihze.kotlinnight.example.presentation.main.MainContract
import me.dnihze.kotlinnight.example.presentation.main.MainModel
import me.dnihze.kotlinnight.example.presentation.main.MainPresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainContract.View {

    @Inject lateinit var daggerPresenter: MainPresenter
    @InjectPresenter lateinit var moxyPresenter: MainPresenter
    @ProvidePresenter fun providePresenter() = daggerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        App[this].component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun set(model: MainModel) {
        Toast.makeText(this, model.toString(), Toast.LENGTH_SHORT).show()
    }
}
