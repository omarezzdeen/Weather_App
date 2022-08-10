package com.example.weatherapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.DataManager
import com.example.weatherapp.R
import com.example.weatherapp.data.model.Weathers
import com.example.weatherapp.databinding.ItemWeatherDailyBinding
import com.example.weatherapp.util.Constants
import com.example.weatherapp.util.formatDate

class WeatherDailyAdapter(private val list: List<Weathers.Daily>): RecyclerView.Adapter<WeatherDailyAdapter.WeatherDailyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDailyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather_daily, parent, false)
        return WeatherDailyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WeatherDailyViewHolder, position: Int) {
        val dataManger = DataManager()
        holder.binding.apply {
            titleTextViewDay.text = list[position].dt?.formatDate(Constants.TYPE_DATE_DAILY)
//            checkWeatherImage(holder, position)
//            imageViewDay.setImageResource(dataManger.checkWeatherImage(list[position].weatherStatus?.get(0)?.icon))
            textViewTempMax.text = "${list[position].temp.max.toInt()}°"
            textViewTempMin.text = "${list[position].temp.min.toInt()}°"
        }

    }

    override fun getItemCount(): Int = list.size

    class WeatherDailyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemWeatherDailyBinding.bind(itemView)
    }

}
