package com.example.weatherapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.DataManager
import com.example.weatherapp.R
import com.example.weatherapp.data.Daily
import com.example.weatherapp.databinding.ItemWeatherDailyBinding
import com.example.weatherapp.util.Constants

class WeatherDailyAdapter(private val list: List<Daily>): RecyclerView.Adapter<WeatherDailyAdapter.WeatherDailyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDailyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather_daily, parent, false)
        return WeatherDailyViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherDailyViewHolder, position: Int) {
        val dataManger = DataManager
        holder.binding.apply {
            titleTextViewDay.text = dataManger.transformationUnixTimestampForDate(list[position].dt, Constants.TYPE_DATE_DAILY)
            imageViewDay.setImageResource(R.drawable.group)
            textViewTempMax.text = "${list[position].temp.max.toInt()}°"
            textViewTempMin.text = "${list[position].temp.min.toInt()}°"
        }

    }

    override fun getItemCount(): Int = list.size



    class WeatherDailyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemWeatherDailyBinding.bind(itemView)
    }

}
