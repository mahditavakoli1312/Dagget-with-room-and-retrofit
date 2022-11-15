package com.example.dagger_with_room_retrofit_base_on_reqres.core.di

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
    fun provideBaseUrl(): String = Urls.BASE_URL

    @Provides
    fun provideRetrofit(
        @Named("base_url") base_url: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}