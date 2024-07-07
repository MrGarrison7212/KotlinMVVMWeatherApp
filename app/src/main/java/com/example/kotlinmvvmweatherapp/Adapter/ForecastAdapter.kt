package com.example.kotlinmvvmweatherapp.Adapter

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvmweatherapp.databinding.ForecastViewholderBinding
import com.example.kotlinmvvmweatherapp.model.ForecastResponseApi

class ForecastAdapter:RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    private lateinit var binding: ForecastViewholderBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ForecastViewholderBinding.inflate(inflater, parent, false)
        return ViewHolder()
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ForecastAdapter.ViewHolder, position: Int) {
        val binding = ForecastViewholderBinding.bind(holder.itemView)
        val data=SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(differ.currentList[position].dtTxt.toString())
        val calendar=Calendar.getInstance()
        calendar.time.date

        val dayOfWeekName = when (calendar.get(Calendar.DAY_OF_WEEK)) {
            1 -> "Sun"
            2 -> "Mon"
            3 -> "Tue"
            4 -> "Wed"
            5 -> "Thu"
            6 -> "Fri"
            7 -> "Sat"
            else -> "-"
        }
        binding.nameDayTxt.text = dayOfWeekName
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val amPM = if(hour < 12) "am" else "pm"
        val hour12 = calendar.get(Calendar.HOUR)
        binding.hourTxt.text = hour12.toString() + amPM
        binding.tempTxt.text = differ.currentList[position].main?.temp?.let { Math.round(it) }.toString() + "°"

        val icon = when(differ.currentList[position].weather?.get(0)?.icon.toString()){
            "01d","0n"->"sunny"
            "02d","02n"->"cloudy_sunny"
            "03d","03n"->"cloudy_sunny"
            "04d","04n"->"cloudy"
            "09d","09n"->"rainy"
            "010d","010n"->"rainy"
            "011d","011n"->"storm"
            "013d","013n"->"snowy"
            "050d","050n"->"windy"
            else -> "sunny"
        }
    }

    override fun getItemCount() = differ.currentList.size

    private val differCallback = object :DiffUtil.ItemCallback<ForecastResponseApi.data>(){
        override fun areItemsTheSame(
            oldItem: ForecastResponseApi.data,
            newItem: ForecastResponseApi.data
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ForecastResponseApi.data,
            newItem: ForecastResponseApi.data
        ): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)

}