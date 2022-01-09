package com.example.umbrella.repository

import com.example.umbrella.BuildConfig
import com.example.umbrella.network.WeatherApi
import com.example.umbrella.network.apiresults.WeatherApiDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private val networkClient = NetworkClient()
    private val databaseClient = DatabaseClient()

    fun getWeather(longitude: Float,latitude: Float, onResponse: ()->Unit, onFailure: ()->Unit) {
        networkClient.getWeather(longitude, latitude, "Current,Minutely,Hourly", BuildConfig.WEATHER_KEY, onResponse, onFailure)
    }
}

//Todo: refactor to use coroutines instead of callbacks. Also needs to be done in WeatherApi interface.
class NetworkClient {
    private val service = WeatherApi.create()
    //Add error checking.
    fun getWeather(longitude: Float, latitude: Float, excluded: String, appId: String, onResponse: ()->Unit, onFailure: ()->Unit) {
        val weather = service.getWeather(longitude,latitude,excluded, appId).enqueue(object: Callback<WeatherApiDto>{
            override fun onResponse(call: Call<WeatherApiDto>, response: Response<WeatherApiDto>) {
                onResponse()
            }
            override fun onFailure(call: Call<WeatherApiDto>, t: Throwable) {
                onFailure()
                t.printStackTrace()
            }
        })
    }
}

class DatabaseClient {

}