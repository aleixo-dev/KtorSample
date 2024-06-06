package com.example.models

import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class User(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val lastName: String
)

val userStorage = mutableListOf(
    User(
        name = "Jonh",
        lastName = "Doe"
    ),
    User(
        name = "Murphy",
        lastName = "Care"
    ),
)