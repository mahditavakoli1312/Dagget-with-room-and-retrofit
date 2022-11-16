package com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.di

import dagger.Component
import retrofit2.Retrofit

@Component(modules = [NetworkModules::class])
interface NetworkComponent {

    fun retrofit(): Retrofit

    @Component.Factory
    interface Factory {
        fun create(
        ): NetworkComponent
    }
}