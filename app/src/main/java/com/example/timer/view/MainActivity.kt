package com.example.timer.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.timer.R
import com.example.timer.adapter.CoinsAdapter
import com.example.timer.viewmodel.CoinsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: CoinsViewModel
    private val coinsAdapter = CoinsAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[CoinsViewModel::class.java]

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = coinsAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.coins.observe(this) { coins ->
            coins.let {
                coinsAdapter.updateCoins(it)
            }
        }
    }
}