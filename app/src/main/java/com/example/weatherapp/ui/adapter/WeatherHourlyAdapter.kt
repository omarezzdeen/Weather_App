package com.example.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.DataManager
import com.example.weatherapp.R
import com.example.weatherapp.data.model.Weathers
import com.example.weatherapp.databinding.ItemWeatherHourlyBinding
import com.example.weatherapp.databinding.ItemWeatherHourlyCardBinding
import com.example.weatherapp.util.Constants
import com.example.weatherapp.util.formatDate
import java.lang.Exception

class WeatherHourlyAdapter(private val list: List<Weathers.Hourly>) :
    RecyclerView.Adapter<WeatherHourlyAdapter.BaseWeatherViewHolder>() {

    private val dataManger = DataManager()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseWeatherViewHolder {
        return when (viewType) {
            1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_weather_hourly_card, parent, false)
                WeatherHourlyCardAdapter(view)
            }
            2 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_weather_hourly, parent, false)
                WeatherHourlyViewHolder(view)
            }
            else -> throw Exception("Unknown view type")

        }
    }

    override fun onBindViewHolder(holder: BaseWeatherViewHolder, position: Int) {
        when (holder) {
            is WeatherHourlyViewHolder -> bindHourly(holder, position)
            is WeatherHourlyCardAdapter -> bindHourlyCard(holder, position)
        }


    }

    private fun bindHourly(holder: WeatherHourlyViewHolder, position: Int) {
        val check = list[position].weatherStatus?.map { it.main }?.contains("Clouds")
        holder.binding.apply {
            temperatureTextView.text = list[position].temp?.toInt().toString()
//            checkWeatherImage(holder, position)
            dayTextView.text =
                list[position].dt?.formatDate(Constants.TYPE_DATE_HOURLY)
        }
    }


    private fun bindHourlyCard(holder: WeatherHourlyCardAdapter, position: Int) {
        holder.binding.apply {
            temperatureTextView.text = list[position].temp?.toInt().toString()
//            if(check(position, "Clear")){
//                holder.binding.weatherImageView.setImageResource(R.drawable.group)
//            } else if(check(position, "Clouds")) {
//                holder.binding.weatherImageView.setImageResource(R.drawable.weather_variable_sun)
//            } else if(check(position, "Rain")) {
//                holder.binding.weatherImageView.setImageResource(R.drawable.weather_rain)
//            } else {
//                holder.binding.weatherImageView.setImageResource(R.drawable.weather_variable_sun)
//            }
            dayTextView.text = "Now"
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) 1 else 2
    }


//    private fun checkWeatherImage(holder: WeatherHourlyViewHolder, position: Int) {
//        if(check(position, "Clear")){
//            holder.binding.weatherImageView.setImageResource(R.drawable.group)
//        } else if(check(position, "Clouds")) {
//            holder.binding.weatherImageView.setImageResource(R.drawable.weather_variable_sun)
//        } else if(check(position, "Rain")) {
//            holder.binding.weatherImageView.setImageResource(R.drawable.weather_rain)
//        } else {
//            holder.binding.weatherImageView.setImageResource(R.drawable.weather_variable_sun)
//        }
//    }
//


    abstract class BaseWeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class WeatherHourlyViewHolder(itemView: View) : BaseWeatherViewHolder(itemView) {
        val binding = ItemWeatherHourlyBinding.bind(itemView)
    }

    class WeatherHourlyCardAdapter(itemView: View) : BaseWeatherViewHolder(itemView) {
        val binding = ItemWeatherHourlyCardBinding.bind(itemView)
    }
}
