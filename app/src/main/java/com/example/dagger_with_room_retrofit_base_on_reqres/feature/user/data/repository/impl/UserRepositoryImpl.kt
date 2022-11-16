package com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.repository.impl

import com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.ResultWrapper
import com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.safeApiCall
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.datasource.remote.UserRemoteDataSource
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.model.response.UserDataResponse
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.repository.UserRepository
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.ui.model.UserView
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.ui.model.toUserView
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {
    override suspend fun getUsersData(): ResultWrapper<List<UserView>?> {
        return safeApiCall(
            api = { userRemoteDataSource.getUser()?.map { userDataResponse ->
            userDataResponse.toUserView()

            } },
            localDataForErrorState = null
        )
    }
}