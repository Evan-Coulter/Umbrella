package com.example.umbrella.repository

import com.example.umbrella.BuildConfig
import com.example.umbrella.network.NetworkClient
import com.example.umbrella.network.WeatherApi
import com.example.umbrella.network.apiresults.WeatherApiDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NetworkRepository @Inject constructor() {
    @Inject
    lateinit var networkClient: NetworkClient

    fun getWeather(longitude: Float,latitude: Float, onResponse: ()->Unit, onFailure: ()->Unit) {
        networkClient.getWeather(longitude, latitude, "Current,Minutely,Hourly", BuildConfig.WEATHER_KEY, onResponse, onFailure)
    }

    fun addCityToObserve(name: String) {
        //TODO.
    }
}