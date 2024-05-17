package com.example.kotlinmvvmweatherapp.Activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvmweatherapp.R
import com.example.kotlinmvvmweatherapp.ViewModel.WeatherViewModel
import com.example.kotlinmvvmweatherapp.databinding.ActivityMainBinding
import com.example.kotlinmvvmweatherapp.model.CurrentResponseApi
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

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
            weatherViewModel.loadCurrentWeather(lat, lon, unit = "metric").enqueue(object : retrofit2.Callback<CurrentResponseApi> {
                override fun onResponse(
                    call: Call<CurrentResponseApi>,
                    response: Response<CurrentResponseApi>
                ) {
                    if(response.isSuccessful){
                        val data = response.body()
                        progressBar.visibility = View.GONE
                        detailLayout.visibility = View.VISIBLE
                        data?.let {
                            statusTxt.text = it.weather?.get(0)?.main ?:  "-"
                            windTxt.text = it.wind.speed.let { Math.round(it).toString() } + "Km"
                            currentTempTxt.text = it.main.temp.let { Math.round(it).toString() } + "°"
                            maxTempTxt.text = it.main.tempMax.let { Math.round(it).toString() } + "°"
                            minTempTxt.text = it.main.tempMin.let { Math.round(it).toString() } + "°"

                        }
                    }
                }

                override fun onFailure(call: Call<CurrentResponseApi>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_SHORT).show()
                }

            })
        }


    }
}