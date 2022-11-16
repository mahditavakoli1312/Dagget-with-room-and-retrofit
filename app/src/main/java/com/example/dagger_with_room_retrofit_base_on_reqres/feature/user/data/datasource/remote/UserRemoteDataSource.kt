package com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.datasource.remote

import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.model.response.UserDataResponse

interface UserRemoteDataSource {
   suspend fun getUser(): List<UserDataResponse>?
}