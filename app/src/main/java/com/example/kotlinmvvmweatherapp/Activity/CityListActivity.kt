package com.example.kotlinmvvmweatherapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.example.kotlinmvvmweatherapp.Adapter.CityAdapter
import com.example.kotlinmvvmweatherapp.R
import com.example.kotlinmvvmweatherapp.ViewModel.CityViewModel
import com.example.kotlinmvvmweatherapp.databinding.ActivityCityListBinding
import com.example.kotlinmvvmweatherapp.databinding.CityViewholderBinding
import com.example.kotlinmvvmweatherapp.model.CityResponseApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CityListActivity : AppCompatActivity() {
    lateinit var binding : ActivityCityListBinding
    private val cityAdapter by lazy { CityAdapter() }
    private val cityViewModel: CityViewModel by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            cityEdt.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                    progressBar3.visibility = View.VISIBLE
                    cityViewModel.loadCity(s.toString(), 10).enqueue(object :
                        Callback<CityResponseApi>{
                        override fun onResponse(
                            call: Call<CityResponseApi>,
                            response: Response<CityResponseApi>
                        ) {
                            TODO("Not yet implemented")
                        }

                        override fun onFailure(call: Call<CityResponseApi>, t: Throwable) {
                            TODO("Not yet implemented")
                        }

                    })
                }

            })
        }
    }

}