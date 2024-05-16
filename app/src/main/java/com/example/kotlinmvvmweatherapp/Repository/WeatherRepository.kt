package com.example.kotlinmvvmweatherapp.Repository

import com.example.kotlinmvvmweatherapp.Server.ApiServices
import com.example.kotlinmvvmweatherapp.model.CurrentResponseApi
import retrofit2.Call

class WeatherRepository(val api: ApiServices) {

    // adding Call and return value - using call and it functions ( enqueque in MainActivity )
    fun getCurrentWeather(lat : Double, lng : Double, unit : String) : Call<CurrentResponseApi> {
        return api.getCurrentWeather(lat, lng, unit, "eddbf8e49a204cda0a75ffa77a47f0c4")
    }
}