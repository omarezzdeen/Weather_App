package com.example.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.DataManager
import com.example.weatherapp.R
import com.example.weatherapp.data.*
import com.example.weatherapp.databinding.*
import com.example.weatherapp.util.Constants
import java.lang.Exception

class HomeAdapter(private val items: List<HomeItem<Any>>): RecyclerView.Adapter<HomeAdapter.BaseHomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHomeViewHolder {
        return when (viewType) {
            VIEW_TYPE_CARD -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.header_card, parent, false)
                HeaderViewHolder(view)
            }
            VIEW_TYPE_HOURLY -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_hourly_list, parent, false)
                WeatherHourlyViewHolder(view)
            }
            VIEW_TYPE_DAILY -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_daily_list, parent, false)
                WeatherDailyViewHolder(view)
            }
            VIEW_TYPE_TITLE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.title_item, parent, false)
                TitleViewHolder(view)
            }
            VIEW_TYPE_DETAILS -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_details, parent, false)
                WeatherDetailsViewHolder(view)
            }
            else -> throw Exception("Unknown view type")

        }
    }


    override fun onBindViewHolder(holder: BaseHomeViewHolder, position: Int) {
        when(holder) {
            is HeaderViewHolder -> bindHeader(holder, position)
            is WeatherHourlyViewHolder -> bindHourly(holder, position)
            is WeatherDailyViewHolder -> bindDaily(holder, position)
            is TitleViewHolder -> bindTitle(holder, position)
            is WeatherDetailsViewHolder -> bindDetails(holder, position)
        }
    }

    private fun bindHeader(holder: HeaderViewHolder, position: Int) {
        val currentItem = items[position].item as Weather
        val data = currentItem.current
        holder.binding.apply {
            textMain.text = data.weather[0].main
            textTemp.text = data.temp.toInt().toString()
            textDescription.text = data.weather[0].description
            textTempMax.text = currentItem.daily[0].temp.max.toInt().toString()
            textTempMin.text = currentItem.daily[0].temp.min.toInt().toString()

        }
    }

    private fun bindHourly(holder: WeatherHourlyViewHolder, position: Int) {
        val currentItem = items[position].item as List<Hourly>
        val adapter = WeatherHourlyAdapter(currentItem)
        holder.binding.recyclerViewHourly.adapter = adapter

    }

    private fun bindDaily(holder: WeatherDailyViewHolder, position: Int) {
        val currentItem = items[position].item as List<Daily>
        val adapter = WeatherDailyAdapter(currentItem)
        holder.binding.recyclerViewDaily.adapter = adapter
    }
    private fun bindTitle(holder: TitleViewHolder, position: Int) {
        val current = items[position].item as String
        holder.binding.apply {
            titleTextView.text = current
        }
    }
    private fun bindDetails(holder: WeatherDetailsViewHolder, position: Int) {
        val currentItem = items[position].item as Weather
        val data = currentItem.current
        val dataManger = DataManager
        holder.binding.apply {
            textSunrise.text = dataManger.transformationUnixTimestampForDate(data.sunrise, Constants.TYPE_DATE_DETAILS)
            textSunset.text = dataManger.transformationUnixTimestampForDate(data.sunset, Constants.TYPE_DATE_DETAILS)
            textHumidity.text = data.humidity.toString()
            textWind.text = data.wind_speed.toString()
            textFeelsLike.text = data.feels_like.toString()
            textPressure.text = data.pressure.toString()
            textVisibility.text = data.visibility.toString()
        }
    }
    override fun getItemCount(): Int = items.size

    abstract class BaseHomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    class HeaderViewHolder(itemView: View): BaseHomeViewHolder(itemView) {
        val binding = HeaderCardBinding.bind(itemView)
    }

    class WeatherHourlyViewHolder(itemView: View): BaseHomeViewHolder(itemView) {
        val binding = ItemHourlyListBinding.bind(itemView)
    }

    class WeatherDailyViewHolder(itemView: View): BaseHomeViewHolder(itemView) {
        val binding = ItemDailyListBinding.bind(itemView)
    }
    class TitleViewHolder(itemView: View): BaseHomeViewHolder(itemView) {
        val binding = TitleItemBinding.bind(itemView)
    }
    class WeatherDetailsViewHolder(itemView: View): BaseHomeViewHolder(itemView) {
        val binding = ItemDetailsBinding.bind(itemView)
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position].type){
            HomeItemType.TYPE_HEADER -> VIEW_TYPE_CARD
            HomeItemType.TYPE_HOURLY -> VIEW_TYPE_HOURLY
            HomeItemType.TYPE_TITLE-> VIEW_TYPE_TITLE
            HomeItemType.TYPE_DAILY -> VIEW_TYPE_DAILY
            HomeItemType.TYPE_DETAILS -> VIEW_TYPE_DETAILS
        }
    }

    companion object {
        private const val VIEW_TYPE_CARD = 1
        private const val VIEW_TYPE_HOURLY = 2
        private const val VIEW_TYPE_TITLE = 3
        private const val VIEW_TYPE_DAILY = 4
        private const val VIEW_TYPE_DETAILS = 5
    }
}