package com.example.timer.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.timer.api.CoinsService
import com.example.timer.model.CoinsDatabase
import com.example.timer.model.CoinsItem
import kotlinx.coroutines.launch

class CoinsViewModel(application: Application) : BaseViewModel(application) {

    private val coinsService = CoinsService()

    private val _coins = MutableLiveData<ArrayList<CoinsItem>>()
    val coins: LiveData<ArrayList<CoinsItem>>
        get() = _coins

    init {
        fetchCoins()
    }

    private fun fetchCoins() {
        viewModelScope.launch {
            coinsService.getCoins().let { response ->
                if (response.isSuccessful) {
                    _coins.postValue(response.body())
                    storeCoinsLocally(_coins.value)

                } else {
                    Log.d("tag", "Error fetchCoins: ${response.code()}")
                }
            }
        }
    }

    private fun storeCoinsLocally(coinsList: ArrayList<CoinsItem>?) {
        launch {
            val dao = CoinsDatabase(getApplication()).coinsDao()
            dao.deleteAllCoins()
            val result = coinsList?.let { dao.insertAll(it) }
        }
    }
}