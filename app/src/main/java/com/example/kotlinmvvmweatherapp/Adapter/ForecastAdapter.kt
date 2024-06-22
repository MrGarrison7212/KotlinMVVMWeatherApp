package com.example.kotlinmvvmweatherapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvmweatherapp.databinding.ForecastViewholderBinding
import com.example.kotlinmvvmweatherapp.model.ForecastResponseApi

class ForecastAdapter:RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    private lateinit var binding: ForecastViewholderBinding

    class ViewHolder {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binging = ForecastViewholderBinding.inflate(inflater, parent, false)
        return viewHolder()
    }

    override fun onBindViewHolder(holder: ForecastAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = differ.currentList.size
    }

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