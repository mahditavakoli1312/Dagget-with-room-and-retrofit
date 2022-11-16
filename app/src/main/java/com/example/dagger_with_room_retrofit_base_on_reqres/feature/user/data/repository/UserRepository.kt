package com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.repository

import com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.ResultWrapper
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.model.response.UserDataResponse
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.ui.model.UserView

interface UserRepository {
    suspend fun getUsersData(): ResultWrapper<List<UserView>?>
}