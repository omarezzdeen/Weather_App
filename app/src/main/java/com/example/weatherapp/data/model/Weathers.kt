package com.example.weatherapp.data.model

import com.google.gson.annotations.SerializedName

sealed class Weathers {

    data class Current(
        @SerializedName("clouds")
        val clouds: Double?,
        @SerializedName("dew_point")
        val dewPoint: Double?,
        @SerializedName("dt")
        val dt: Int?,
        @SerializedName("feels_like")
        val feelsLike: Double?,
        @SerializedName("humidity")
        val humidity: Double?,
        @SerializedName("pressure")
        val pressure: Double?,
        @SerializedName("sunrise")
        val sunrise: Int?,
        @SerializedName("sunset")
        val sunset: Int?,
        @SerializedName("temp")
        val temp: Double?,
        @SerializedName("uvi")
        val uvi: Double?,
        @SerializedName("visibility")
        val visibility: Double?,
        @SerializedName("weather")
        val weatherStatus: List<WeatherStatus>?,
        @SerializedName("wind_deg")
        val windDeg: Double?,
        @SerializedName("wind_speed")
        val windSpeed: Double?
    )

    data class Daily(
        @SerializedName("clouds")
        val clouds: Double?,
        @SerializedName("dew_point")
        val dewPoint: Double?,
        @SerializedName("dt")
        val dt: Int?,
        @SerializedName("feels_like")
        val feelsLike: FeelsLike?,
        @SerializedName("humidity")
        val humidity: Double?,
        @SerializedName("moon_phase")
        val moonPhase: Double?,
        @SerializedName("moonrise")
        val moonrise: Int?,
        @SerializedName("moonset")
        val moonset: Int?,
        @SerializedName("pop")
        val pop: Double?,
        @SerializedName("pressure")
        val pressure: Double?,
        @SerializedName("rain")
        val rain: Double?,
        @SerializedName("sunrise")
        val sunrise: Int?,
        @SerializedName("sunset")
        val sunset: Int?,
        @SerializedName("temp")
        val temp: Temp,
        @SerializedName("uvi")
        val uvi: Double?,
        @SerializedName("weather")
        val weatherStatus: List<WeatherStatus>?,
        @SerializedName("wind_deg")
        val windDeg: Double?,
        @SerializedName("wind_gust")
        val windGust: Double?,
        @SerializedName("wind_speed")
        val windSpeed: Double?
    )

    data class FeelsLike(
        @SerializedName("day")
        val day: Double?,
        @SerializedName("eve")
        val eve: Double?,
        @SerializedName("morn")
        val morn: Double?,
        @SerializedName("night")
        val night: Double?
    )

    data class Hourly(
        @SerializedName("clouds")
        val clouds: Double?,
        @SerializedName("dew_point")
        val dewPoint: Double?,
        @SerializedName("dt")
        val dt: Int?,
        @SerializedName("feels_like")
        val feelsLike: Double?,
        @SerializedName("humidity")
        val humidity: Double?,
        @SerializedName("pop")
        val pop: Double?,
        @SerializedName("pressure")
        val pressure: Double?,
        @SerializedName("temp")
        val temp: Double?,
        @SerializedName("uvi")
        val uvi: Double?,
        @SerializedName("visibility")
        val visibility: Double?,
        @SerializedName("weather")
        val weatherStatus: List<WeatherStatus>?,
        @SerializedName("wind_deg")
        val windDeg: Double?,
        @SerializedName("wind_gust")
        val windGust: Double?,
        @SerializedName("wind_speed")
        val windSpeed: Double?
    )

    data class Minutely(
        @SerializedName("dt")
        val dt: Int?,
        @SerializedName("precipitation")
        val precipitation: Double?
    )

    data class Temp(
        @SerializedName("day")
        val day: Double?,
        @SerializedName("eve")
        val eve: Double?,
        @SerializedName("max")
        val max: Double,
        @SerializedName("min")
        val min: Double,
        @SerializedName("morn")
        val morn: Double?,
        @SerializedName("night")
        val night: Double?
    )

    data class WeatherModel(
        @SerializedName("current")
        val current: Current,
        @SerializedName("daily")
        val daily: List<Daily>?,
        @SerializedName("hourly")
        val hourly: List<Hourly>?,
        @SerializedName("lat")
        val lat: Double?,
        @SerializedName("lon")
        val lon: Double?,
        @SerializedName("minutely")
        val minutely: List<Minutely>?,
        @SerializedName("timezone")
        val timezone: String?,
        @SerializedName("timezone_offset")
        val timezoneOffset: Int?
    )

    data class WeatherStatus(
        @SerializedName("description")
        val description: String?,
        @SerializedName("icon")
        val icon: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("main")
        val main: String?
    )
}