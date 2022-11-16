package com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.model.response

import com.google.gson.annotations.SerializedName

data class UserSupportResponse(
    @SerializedName("url") val url: String? = null,
    @SerializedName("text") val text: String? = null
)