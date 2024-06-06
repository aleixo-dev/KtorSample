package com.example.routes

import com.example.models.User
import com.example.models.userStorage
import com.example.repository.UserRepository
import com.example.routes.user.request.UserRequest
import com.example.routes.user.response.UserResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID

fun Route.userRoute(
    userRepository: UserRepository
) {

    post {
        val userRequest = call.receive<UserRequest>()

        userRepository.save(
            user = userRequest.toModel()
        )

        call.respond(HttpStatusCode.Created)
    }

    get {

        val users = userRepository.findAll()

        call.respond(
            message = users.map(User::toResponse)
        )

    }

    get("{id?}") {

        val id = call.parameters["id"] ?: return@get call.respond(HttpStatusCode.BadRequest)

        val founderUser = userRepository.findById(id) ?: return@get call.respond(HttpStatusCode.NotFound)

        call.respond(
            message = founderUser.toResponse()
        )

    }
}


private fun UserRequest.toModel(): User =
    User(
        id = UUID.randomUUID().toString(),
        name = this.name,
        lastName = this.lastName
    )

private fun User.toResponse(): UserResponse =
    UserResponse(
        id = this.id,
        name = this.name,
        lastName = this.lastName
    )