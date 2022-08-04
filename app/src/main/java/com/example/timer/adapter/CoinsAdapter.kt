package com.example.timer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.timer.R
import com.example.timer.model.CoinsItem
import kotlinx.android.synthetic.main.coins_item.view.*

class CoinsAdapter(private val coinsList: ArrayList<CoinsItem>) :
    RecyclerView.Adapter<CoinsAdapter.CoinsViewHolder>() {

    inner class CoinsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvIdValue: TextView = view.tvIdValue
        private val tvTypeValue: TextView = view.tvTypeValue
        fun bind(coinsItem: CoinsItem) {
            tvIdValue.text = coinsItem.id
            tvTypeValue.text = coinsItem.type
        }
    }

    fun updateCoins(newCoins: ArrayList<CoinsItem>) {
        coinsList.clear()
        coinsList.addAll(newCoins)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CoinsViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.coins_item, parent, false)
    )

    override fun onBindViewHolder(holder: CoinsViewHolder, position: Int) {
        holder.bind(coinsList[position])
    }

    override fun getItemCount() = coinsList.size

}