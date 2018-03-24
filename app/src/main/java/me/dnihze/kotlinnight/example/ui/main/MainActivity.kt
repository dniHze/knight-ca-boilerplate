package me.dnihze.kotlinnight.example.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
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
import kotlinx.android.synthetic.main.activity_main.*
import me.dnihze.kotlinnight.example.ui.adapter.FactsAdapter
import kotlin.properties.Delegates

class MainActivity : MvpAppCompatActivity(), MainContract.View {

    @Inject lateinit var daggerPresenter: MainPresenter
    @Suppress("unused")
    @InjectPresenter lateinit var moxyPresenter: MainPresenter
    @ProvidePresenter fun providePresenter() = daggerPresenter

    private var adapter: FactsAdapter by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        App[this].component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = FactsAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.setCallback {
            daggerPresenter.swapLike(it)
        }
    }

    override fun set(model: MainModel) {
        val (loading, error, data) = model
        progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        if (error != null) {
            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
        } else {
            adapter.data = data
        }
    }
}
