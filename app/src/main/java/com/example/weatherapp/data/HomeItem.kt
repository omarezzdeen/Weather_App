package com.example.weatherapp.data

import com.example.weatherapp.data.enums.HomeItemType

data class HomeItem<T>(
    val item: T,
    val type: HomeItemType
)
