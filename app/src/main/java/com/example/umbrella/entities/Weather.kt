package com.example.umbrella.entities

data class Weather (val city: City,
                    val high: Double,
                    val low: Double,
                    val alerts: String)