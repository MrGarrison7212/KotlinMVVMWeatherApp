package com.example.kotlinmvvmweatherapp.Server

import com.example.kotlinmvvmweatherapp.model.CityResponseApi
import com.example.kotlinmvvmweatherapp.model.CurrentResponseApi
import com.example.kotlinmvvmweatherapp.model.ForecastResponseApi
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

    @GET("forecast")
    fun getForecastWeather(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double,
        @Query("units") units:String,
        @Query("appid") ApiKey:String,
    ) : Call<ForecastResponseApi>

    @GET("geo/1.0/direct")
    fun getCitiesList(
        @Query("q") q:String,
        @Query("limit") limit:Int,
        @Query("appid") ApiKey:String,
    ) : Call<CityResponseApi>
}