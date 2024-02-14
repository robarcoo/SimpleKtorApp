package com.example.models

import com.google.gson.Gson
import kotlinx.serialization.Serializable

@Serializable
data class contacts(val phone: String = "", val email: String = "")

@Serializable
data class candidate_info(
    val name: String = "",
    val profession: String = "",
    val sex: String = "",
    val birth_date: String = "",
    val contacts: contacts = contacts(),
    val relocation: String = ""
)

@Serializable
data class Education(
    val type: String = "",
    val year_start: String = "",
    val year_end: String = "",
    val description: String = ""
)

@Serializable
data class job_experience(
    val date_start: String = "",
    val date_end: String = "",
    val company_name: String = "",
    val description: String = ""
)

@Serializable
data class Candidate(
    val id : Int,
    val candidate_info: candidate_info = candidate_info(),
    val education: List<Education> = emptyList(),
    val job_experience: List<job_experience> = emptyList(),
    val free_form: String = ""
)


val lines = object {}.javaClass.getResourceAsStream("/resume.json")?.bufferedReader()?.readText()
val gson = Gson()
val candidate: Candidate = gson.fromJson(lines, Candidate::class.java)
val candidateStorage = listOf(candidate)
