package com.example.umbrella.network.apiresults.subclasses

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)