package com.example.kotlinmvvmweatherapp.Server

import com.example.kotlinmvvmweatherapp.model.CurrentResponseApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("weather")
    fun getCurrentWeather(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double,
        @Query("units") units:String,
        @Query("appid") ApiKey:String,
    ) : Call<CurrentResponseApi>
}