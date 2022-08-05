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
        val dataManger = DataManager()
        holder.binding.apply {
            titleTextViewDay.text = dataManger.transformationUnixTimestampForDate(list[position].dt, Constants.TYPE_DATE_DAILY)
            checkWeatherImage(holder, position)
            textViewTempMax.text = "${list[position].temp.max.toInt()}°"
            textViewTempMin.text = "${list[position].temp.min.toInt()}°"
        }

    }

    override fun getItemCount(): Int = list.size

    private fun checkWeatherImage(holder: WeatherDailyViewHolder, position: Int) {
        if(check(position, "Clear")){
            holder.binding.imageViewDay.setImageResource(R.drawable.group)
        } else if(check(position, "Clouds")) {
            holder.binding.imageViewDay.setImageResource(R.drawable.weather_variable_sun)
        } else if(check(position, "Rain")) {
            holder.binding.imageViewDay.setImageResource(R.drawable.weather_rain)
        } else {
            holder.binding.imageViewDay.setImageResource(R.drawable.weather_variable_sun)
        }
    }

    fun check(position: Int, isCheck: String) = list[position].weather.map { it.main }.contains(isCheck)


    class WeatherDailyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemWeatherDailyBinding.bind(itemView)
    }

}
