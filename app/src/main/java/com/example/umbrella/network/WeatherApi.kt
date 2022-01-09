package com.example.umbrella.network

import com.example.umbrella.BuildConfig
import com.example.umbrella.network.apiresults.WeatherApiDto
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/data/2.5/onecall")
    fun getWeather( @Query("lon") longitude: Float,
                    @Query("lat") latitude: Float,
                    @Query("exclude") excluded: String,
                    @Query("appid") appId: String): Call<WeatherApiDto>

    companion object {
        fun create() : WeatherApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_WEATHER_URL)
                .build()
            return retrofit.create(WeatherApi::class.java)
        }
    }
}