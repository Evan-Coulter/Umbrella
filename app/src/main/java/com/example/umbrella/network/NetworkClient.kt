package com.example.umbrella.network

import com.example.umbrella.network.apiresults.WeatherApiDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

//Todo: refactor to use coroutines instead of callbacks. Also needs to be done in WeatherApi interface.
class NetworkClient @Inject constructor() {
    private val service = WeatherApi.create()
    //Add error checking.
    fun getWeather(longitude: Float, latitude: Float, excluded: String, appId: String, onResponse: ()->Unit, onFailure: ()->Unit) {
        service.getWeather(longitude,latitude,excluded, appId).enqueue(object:
            Callback<WeatherApiDto> {
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