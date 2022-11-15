package com.example.dagger_with_room_retrofit_base_on_reqres.core.di

import com.example.dagger_with_room_retrofit_base_on_reqres.MainActivity
import dagger.Component

@Component(modules = [NetworkModules::class])
interface NetworkComponent {

    /* TODO : inject method input argument have to change
    *   when we use fragment (instent activity)*/
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
        ): NetworkComponent
    }
}