package com.example.routes.user.response

import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class UserResponse(
    val id : String = UUID.randomUUID().toString(),
    val name : String,
    val lastName : String
)