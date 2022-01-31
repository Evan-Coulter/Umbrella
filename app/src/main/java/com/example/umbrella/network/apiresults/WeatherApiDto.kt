package com.example.umbrella.network.apiresults

import com.example.umbrella.entities.City
import com.example.umbrella.entities.Weather
import com.example.umbrella.network.apiresults.subclasses.Alert
import com.example.umbrella.network.apiresults.subclasses.Current
import com.example.umbrella.network.apiresults.subclasses.Daily

data class WeatherApiDto(
    val alerts: List<Alert>,
    val current: Current,
    val daily: List<Daily>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
) {
    fun toWeather(lon: Double, lat: Double, day: List<Daily>, alert: List<Alert>): Weather{
        return Weather(City.toCity(lon, lat), day[0].temp.min, day[0].temp.max, alert.get(0).description)
    }
}
