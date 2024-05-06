package com.example.kotlinmvvmweatherapp.Repository

import com.example.kotlinmvvmweatherapp.Server.ApiServices

class WeatherRepository(val api: ApiServices) {

    fun getCurrentWeather(lat : Double, lng : Double, unit : String){
        api.getCurrentWeather(lat, lng, unit, "eddbf8e49a204cda0a75ffa77a47f0c4")
    }
}