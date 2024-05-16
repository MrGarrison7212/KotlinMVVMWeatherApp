package com.example.kotlinmvvmweatherapp.Activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvmweatherapp.R
import com.example.kotlinmvvmweatherapp.ViewModel.WeatherViewModel
import com.example.kotlinmvvmweatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val weatherViewModel : WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = Color.TRANSPARENT
        }

        binding.apply {
            var lat = 51.60
            var lon = 0.12
            var name = "London"

            cityTxt.text = name
            progressBar.visibility = View.VISIBLE

        }


    }
}