package com.example.umbrella.viewmodel

import androidx.lifecycle.ViewModel
import com.example.umbrella.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var repository: NetworkRepository

    val weather: String = "Raining"

    fun addCity(name: String) {
        repository.addCityToObserve(name)
    }

    fun getWeather() {
        //TODO with live data and coroutines.
    }
}