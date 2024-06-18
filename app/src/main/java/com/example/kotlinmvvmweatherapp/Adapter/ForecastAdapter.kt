package com.example.kotlinmvvmweatherapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvmweatherapp.databinding.ForecastViewholderBinding

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

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}