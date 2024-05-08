package com.example.kotlinmvvmweatherapp.ViewModel

import androidx.lifecycle.ViewModel
import com.example.kotlinmvvmweatherapp.Repository.WeatherRepository
import com.example.kotlinmvvmweatherapp.Server.ApiClient
import com.example.kotlinmvvmweatherapp.Server.ApiServices

class WeatherViewModel(val repository: WeatherRepository) : ViewModel() {

    constructor():this(WeatherRepository(ApiClient().getClient().create(ApiServices::class.java)))

    fun loadCurrentWeather(lat:Double, lng:Double, unit:String) =
        repository.getCurrentWeather(lat, lng, unit)
}