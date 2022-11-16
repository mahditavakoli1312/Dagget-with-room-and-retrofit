package com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.model.response

import com.google.gson.annotations.SerializedName

data class UserBaseResponse (
    @SerializedName("page") val page: Int? = null,
    @SerializedName("per_page") val perPage: Int? = null,
    @SerializedName("total") val total: Int? = null,
    @SerializedName("total_pages") val totalPages: Int? = null,
    @SerializedName("data") val data: List<UserDataResponse> = listOf(),
    @SerializedName("support") val support: UserSupportResponse? = UserSupportResponse()
)