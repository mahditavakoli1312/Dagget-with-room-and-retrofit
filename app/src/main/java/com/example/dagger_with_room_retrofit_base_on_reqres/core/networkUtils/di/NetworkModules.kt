package com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.di

import com.example.dagger_with_room_retrofit_base_on_reqres.core.data.Urls
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
object NetworkModules {

    @Provides
    @Named("base_url")
    fun provideBaseurl(): String = Urls.BASE_URL

    @Provides
    fun provideRetrofit(
        @Named("base_url") baseUrl: String
    ): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}
