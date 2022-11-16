package com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.network.api

import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.model.response.UserBaseResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUserPage(): Response<UserBaseResponse?>
}