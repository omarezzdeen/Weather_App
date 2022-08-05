package com.example.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.DataManager
import com.example.weatherapp.R
import com.example.weatherapp.data.Hourly
import com.example.weatherapp.databinding.ItemWeatherDailyBinding
import com.example.weatherapp.databinding.ItemWeatherHourlyBinding
import com.example.weatherapp.util.Constants

class WeatherHourlyAdapter(private val list: List<Hourly>): RecyclerView.Adapter<WeatherHourlyAdapter.WeatherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather_hourly, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {

            holder.binding.apply {
                temperatureTextView.text = list[position].temp.toInt().toString()
                weatherImageView.setImageResource(R.drawable.group)
                dayTextView.text = DataManager.transformationUnixTimestampForDate(list[position].dt, Constants.TYPE_DATE_HOURLY)
            }


    }

    override fun getItemCount(): Int = list.size



    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemWeatherHourlyBinding.bind(itemView)
    }
}
