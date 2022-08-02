package com.example.weatherapp.data

data class Weather(
    val base: String,
    var clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    var name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<WeatherElement>,
    val wind: Wind
)