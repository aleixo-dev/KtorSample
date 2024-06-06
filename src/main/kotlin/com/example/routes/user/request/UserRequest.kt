package com.example.routes.user.request

import kotlinx.serialization.Serializable

@Serializable
data class UserRequest(
    val name : String,
    val lastName : String
)
