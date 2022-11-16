package com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.datasource.remote.impl

import com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.bodyOrThrow
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.datasource.remote.UserRemoteDataSource
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.model.response.UserDataResponse
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.network.api.UserApi
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    private val userApi: UserApi
) : UserRemoteDataSource {
    override suspend fun getUser(): List<UserDataResponse>? {
        return userApi.getUserPage().bodyOrThrow()?.data
    }
}
