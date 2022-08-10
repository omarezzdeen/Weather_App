package com.example.weatherapp.util


import android.annotation.SuppressLint
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.data.model.Weathers
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


@SuppressLint("SimpleDateFormat")
fun Int.formatDate(pattern: String): CharSequence {
    val sdf = java.text.SimpleDateFormat(pattern)
    val date = java.util.Date(this.toLong() * 1000)
    return sdf.format(date)
}

//fun transformationUnixTimestampForDate(data: Int?, path: String): CharSequence? {
//    val sdf = java.text.SimpleDateFormat(path)
//    val date = java.util.Date(data?.toLong()!! * 1000)
//    return sdf.format(date)
//}

//fun ImageView.loadWeatherIcon(weatherStatus: Weathers.WeatherStatus?) {
//    when (weatherStatus?.id) {
//        800 -> Glide.with(this)
//            .load(R.drawable.clear_sky)
//            .into(this)
//        801, 804 -> Glide.with(this)
//            .load(R.drawable.weather_variable_sun)
//            .into(this)
//        500 -> Glide.with(this)
//            .load(R.drawable.weather_rain)
//            .into(this)
//        else -> Glide.with(this)
//            .load(Constants.Api.URL_IMAGE + weatherStatus?.icon + Constants.Api.IMAGE_EXTENSION)
//            .into(this)
//    }
//}