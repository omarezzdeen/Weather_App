package com.example.weatherapp.ui.avivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ItemWeatherBinding
import com.example.weatherapp.my_data.Daily
import com.example.weatherapp.my_data.MyWeather

class WeatherAdapter(val listData: List<List<Daily>>): RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather,parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val currentItem = listData[position]
        holder.binding.apply {
        }
    }

    override fun getItemCount(): Int = listData.size

    class WeatherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemWeatherBinding.bind(itemView)
    }
}
