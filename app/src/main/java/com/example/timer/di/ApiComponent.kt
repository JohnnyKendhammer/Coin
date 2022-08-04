package com.example.timer.di

import com.example.timer.api.CoinsService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: CoinsService)
}