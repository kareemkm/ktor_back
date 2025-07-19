package com.kareem

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable


fun Application.configureRouting() {

    install(ContentNegotiation){
        json()
    }

    routing {
        get("/kareem") {
            call.respondText("kareem")
        }
        post("/kareem") {
            val request = call.receive<User>()
            call.respond(mapOf("message" to "Hi ${request.name}! You are ${request.age} years old."))
            call.respond(mapOf("state" to "success"))
        }
        get("/user") {
            val  users = listOf(
                User(
                    id = 1,
                    name = "kareem",
                    age = 23,
                    city = "cairo",
                ),
                User(
                    id = 2,
                    name = "mustafa",
                    age = 54,
                    city = "dearness",
                ),
                User(
                    id = 3,
                    name = "ahmed",
                    age = 120,
                    city = "kkk",
                ),
                User(
                    id = 4,
                    name = "anuelnaga",
                    age = 120,
                    city = "kkkkk",
                )
            )
            call.respond(users)
        }
    }
}


@Serializable
data class User(
    val id: Int = 1,
    val name: String,
    val age: Int,
    val  city: String = "kareem",
)