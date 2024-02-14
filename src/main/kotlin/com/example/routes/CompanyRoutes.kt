package com.example.routes

import com.example.models.companyStorage
import com.example.models.fullVacancyStorage
import com.example.models.vacancyStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.companyRouting() {
    route("/company") {
        get {
            if (companyStorage.isNotEmpty()) {
                call.respond(companyStorage)
            } else {
                call.respondText("No companies found", status = HttpStatusCode.OK)
            }
        }
        get ("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText("", status = HttpStatusCode.OK)
            val company = companyStorage.find { it.id == id.toInt() } ?: return@get call.respondText("", status = HttpStatusCode.OK)
            call.respond(company)
        }
        post {

        }
        delete("{id?}") {

        }
        get ("/vacancies") {
            if (vacancyStorage.isNotEmpty()) {
                call.respond(vacancyStorage)

            } else {
                call.respondText("No vacancies found", status = HttpStatusCode.OK)
            }
        }

        get ("/vacancies/{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText("", status = HttpStatusCode.OK)
            val vacancy = fullVacancyStorage.find { it.id == id.toInt() } ?: return@get call.respondText("", status = HttpStatusCode.OK)
            call.respond(vacancy)
        }


    }


}