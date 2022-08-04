package com.example.timer.api

import com.example.timer.helpers.Constants
import com.example.timer.model.CoinsResponse
import retrofit2.Response
import retrofit2.http.GET

interface CoinsApi {
    @GET(Constants.END_POINT)
    suspend fun getCoins(): Response<CoinsResponse>
}