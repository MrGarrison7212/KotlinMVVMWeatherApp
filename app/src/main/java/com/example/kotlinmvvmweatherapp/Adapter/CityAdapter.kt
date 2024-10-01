package com.example.kotlinmvvmweatherapp.Adapter

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinmvvmweatherapp.databinding.CityViewholderBinding
import com.example.kotlinmvvmweatherapp.databinding.ForecastViewholderBinding
import com.example.kotlinmvvmweatherapp.model.ForecastResponseApi
import kotlin.math.roundToInt

class CityAdapter:RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    private lateinit var binding: CityViewholderBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = CityViewholderBinding.inflate(inflater, parent, false)
        return ViewHolder()
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("SimpleDateFormat", "SetTextI18n", "DiscouragedApi")
    override fun onBindViewHolder(holder: CityAdapter.ViewHolder, position: Int) {
        val binding = CityViewholderBinding.bind(holder.itemView)
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