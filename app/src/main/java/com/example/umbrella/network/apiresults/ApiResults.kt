package com.example.umbrella.network.apiresults

import com.example.umbrella.network.apiresults.subclasses.Alert
import com.example.umbrella.network.apiresults.subclasses.Current
import com.example.umbrella.network.apiresults.subclasses.Daily

data class ApiResults(
    val alerts: List<Alert>,
    val current: Current,
    val daily: List<Daily>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)