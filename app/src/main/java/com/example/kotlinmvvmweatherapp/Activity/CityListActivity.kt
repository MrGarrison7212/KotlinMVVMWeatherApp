package com.example.kotlinmvvmweatherapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.kotlinmvvmweatherapp.Adapter.CityAdapter
import com.example.kotlinmvvmweatherapp.R
import com.example.kotlinmvvmweatherapp.ViewModel.CityViewModel
import com.example.kotlinmvvmweatherapp.databinding.ActivityCityListBinding
import com.example.kotlinmvvmweatherapp.databinding.CityViewholderBinding

class CityListActivity : AppCompatActivity() {
    lateinit var binding : ActivityCityListBinding
    private val cityAdapter by lazy { CityAdapter() }
    private val cityViewModel: CityViewModel by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}