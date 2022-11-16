package com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.di.module

import android.util.Log
import com.example.dagger_with_room_retrofit_base_on_reqres.core.data.Urls
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.datasource.remote.UserRemoteDataSource
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.datasource.remote.impl.UserRemoteDataSourceImpl
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.network.api.UserApi
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.repository.UserRepository
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.repository.impl.UserRepositoryImpl
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.ui.viewModel.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class UserModules {

    @Binds
    abstract fun bindUserRemoteDataSource(impl: UserRemoteDataSourceImpl): UserRemoteDataSource

    @Binds
    abstract fun bindUserReposiyory(impl: UserRepositoryImpl): UserRepository

    companion object {
        @Provides
        fun provideUserApi(retrofit: Retrofit): UserApi {
            return retrofit.create(UserApi::class.java)
        }

        @Provides
        fun provideUserViewModel(userRepository: UserRepository): UserViewModel {
            return UserViewModel(userRepository = userRepository)
        }



    }

}