package com.example.kotlinmvvmweatherapp.Repository

import com.example.kotlinmvvmweatherapp.Server.ApiServices

class CityRepository(val api:ApiServices) {
    fun getCities(q:String, limit:Int) =
        api.getCitiesList(q,limit, "eddbf8e49a204cda0a75ffa77a47f0c4")
}