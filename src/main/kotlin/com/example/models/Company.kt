package com.example.models

import kotlinx.serialization.Serializable




@Serializable
data class Company(
    val id: Int,
    val name: String,
    val activity: String,
    val vacancies: List<VacancyInfo> = listOf(),
    val contacts: String = "8 800 555 35 35"
)

@Serializable
data class VacancyInfo(
    val id: Int,
    val profession: String,
    val level: String,
    val salary: Int,
    val description: String = "The best job ever, earn 300K/nanosec"
)





val companyStorage = mutableListOf(
    Company( 1,
        "OOO SuperPay",
        "banking",
        listOf(VacancyInfo(1, "QA", "middle", 80000),
            VacancyInfo(2, "PM", "senior", 80000)),
    ),

    Company( 2,
        "MTM",
        "banking",
        listOf(VacancyInfo(3, "designer", "senior", 150000))
    ),
    Company( 3,
        "CryptoSuperGo",
        "banking",
        listOf(VacancyInfo(4, "developer", "junior", 90000)),
    ),
    Company(4,
        "PlatiNalogi",
        "public services",
        listOf(
            VacancyInfo(5, "developer", "middle", 150000),
            VacancyInfo(6, "designer", "middle", 100000),
            VacancyInfo(7, "PM", "senior", 160000)
        ),

        ),

    Company(5,
        "NeftGazIkra",
        "public services",
        listOf(VacancyInfo(8, "analyst", "junior", 70000)),
    ),

    Company(6,
        "OOO SoftForHomies",
        "IT",
        listOf(VacancyInfo(9, "PM", "middle", 100000), VacancyInfo(10, "QA", "junior", 60000)),
    ),

    Company(7,
        "MobileGamesPro",
        "IT",
        listOf(VacancyInfo(11, "QA", "senior", 130000)),
    ),


    Company(8,
        "FoodsAndGoods",
        "public services",
        listOf(
            VacancyInfo(12, "developer", "junior", 100000),
            VacancyInfo(13, "designer", "middle", 130000),
            VacancyInfo(14, "analyst", "senior", 150000)
        ),
        ),

    Company(9,
        "VseIgry",
        "IT",
        listOf(
            VacancyInfo(15, "developer", "senior", 200000),
            VacancyInfo(16, "designer", "senior", 180000)
        ),
        ),
    Company(10,
        "ItBankingMax",
        "banking",
        listOf(VacancyInfo(17, "QA", "senior", 140000)),

        )
)

@Serializable
data class Vacancy (
    val name: String,
    val level:String,
    val salary: Int,
    val company: String,
)

@Serializable
data class FullVacancy (
    val id: Int,
    val name: String,
    val level:String,
    val salary: Int,
    val company: String,
    val field: String,
    val description: String,
    val phone: String
)

val vacancyStorage = companyStorage.flatMap { company -> company.vacancies.map { vacancy -> Vacancy(vacancy.profession, vacancy.level, vacancy.salary, company.name) } }
val fullVacancyStorage = companyStorage.flatMap { company -> company.vacancies.map { vacancy -> FullVacancy(vacancy.id, vacancy.profession, vacancy.level, vacancy.salary, company.name, company.activity, vacancy.description, company.contacts) } }