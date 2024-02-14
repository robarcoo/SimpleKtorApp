package com.example.routes

import com.example.models.Candidate
import com.example.models.candidateStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.resumeRouting() {
    route("/resume") {
        get {
            call.respond(candidateStorage)
        }

        post {
            val candidate = call.receive<Candidate>()
            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
            println(candidate)
        }

        get ("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText("", status = HttpStatusCode.OK)
            val candidate = candidateStorage.find { it.id == id.toInt() } ?: return@get call.respondText("", status = HttpStatusCode.OK)
            call.respond(candidate)
        }

        post("{id?}") {
            val id = call.parameters["id"] ?: return@post call.respondText("", status = HttpStatusCode.OK)
            val vacancy = candidateStorage.find { it.id == id.toInt() } ?: return@post call.respondText("", status = HttpStatusCode.OK)
            call.receive<Any>()
            call.respondText("Changes applied successfully", status = HttpStatusCode.Accepted)
            println(vacancy)
        }
    }
}