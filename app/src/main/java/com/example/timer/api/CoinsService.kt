package com.example.timer.api

import com.example.timer.di.DaggerApiComponent
import com.example.timer.model.CoinsResponse
import retrofit2.Response
import javax.inject.Inject

class CoinsService {

    @Inject
    lateinit var coinsApi: CoinsApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    suspend fun getCoins(): Response<CoinsResponse>{
        return coinsApi.getCoins()
    }
}