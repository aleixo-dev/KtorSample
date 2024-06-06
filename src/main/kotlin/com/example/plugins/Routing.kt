package com.example.plugins

import com.example.repository.UserRepository
import com.example.routes.*
import com.example.routes.customer.customerRouting
import com.example.routes.customer.getOrderRoute
import com.example.routes.customer.listOrdersRoute
import com.example.routes.customer.totalizeOrderRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting(
    userRepository: UserRepository
) {
    routing {
        customerRouting()
        listOrdersRoute()
        getOrderRoute()
        totalizeOrderRoute()

        route("/api/user") {
            userRoute(userRepository)
        }
    }
}
