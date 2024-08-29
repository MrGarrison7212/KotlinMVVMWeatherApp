package com.example.kotlinmvvmweatherapp.ViewModel

import androidx.lifecycle.ViewModel
import com.example.kotlinmvvmweatherapp.Repository.CityRepository
import com.example.kotlinmvvmweatherapp.Server.ApiClient
import com.example.kotlinmvvmweatherapp.Server.ApiServices

class CityViewModel(val repository: CityRepository) : ViewModel() {
    constructor() : this(CityRepository(ApiClient().getClient().create(ApiServices::class.java)))
}