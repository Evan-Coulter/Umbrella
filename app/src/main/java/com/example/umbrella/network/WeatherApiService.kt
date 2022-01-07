package com.example.umbrella.network

import com.example.umbrella.network.apiresults.ApiResults
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("data/2.5/onecall")
    fun getWeather( @Query("lon") longitude: Float,
                    @Query("lat") latitude: Float,
                    @Query("exclude") excluded: String,
                    @Query("appid") appId: String): Flow<ApiResults>
}