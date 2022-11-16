package com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.ui.model

import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.model.response.UserDataResponse

data class UserView(
    val id: Int?,
    val name: String?,
    val year: Int?,
)


fun UserDataResponse.toUserView() = UserView(
    id = id,
    name = firstName + " " + lastName,
    year = 123,
)