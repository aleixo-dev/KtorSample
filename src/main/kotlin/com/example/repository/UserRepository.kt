package com.example.repository

import com.example.models.User
import java.util.UUID
import java.util.function.BinaryOperator

class UserRepository {

    private val users = mutableListOf<User>()

    fun findAll() = users

    fun findById(id: String): User? = users.firstOrNull { it.id == id }

    fun findByName(name: String): User? = users.firstOrNull { it.name == name }

    fun save(user: User): Boolean = users.add(user)

}