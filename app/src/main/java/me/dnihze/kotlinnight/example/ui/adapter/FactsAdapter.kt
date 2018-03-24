package me.dnihze.kotlinnight.example.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import me.dnihze.kotlinnight.example.R
import me.dnihze.kotlinnight.example.domain.CatFact

class FactsAdapter : RecyclerView.Adapter<FactsAdapter.Holder>() {

    private val _data: MutableList<CatFact> = mutableListOf()
    private var _callback: (CatFact) -> Unit = { }

    var data: List<CatFact>
        get() = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return Holder(itemView)
    }

    override fun getItemCount() = _data.size

    override fun onBindViewHolder(holder: Holder, position: Int): Unit = with(_data[position]) {
        holder.apply {
            text.text = fact
            likeButton.setImageResource(
                    if (isLiked)
                        R.drawable.ic_favorite
                    else
                        R.drawable.ic_favorite_border)
            likeButton.setOnClickListener {
                _callback(this@with)
            }
        }
    }

    fun setCallback(callback: (CatFact) -> Unit) {
        _callback = callback
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = itemView.findViewById(R.id.text)
        val likeButton: ImageView = itemView.findViewById(R.id.like_button)

    }
}