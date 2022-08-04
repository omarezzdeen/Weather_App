package com.example.weatherapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.DataManager
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.network.Client
import com.example.weatherapp.ui.avivity.WeatherAdapter
import okhttp3.OkHttpClient

class WeatherFragment : Fragment() {
    private lateinit var binding: FragmentWeatherBinding
    private val dataManager = DataManager()
    val client = OkHttpClient()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

        private fun setup() {
            val okHttp = Client(dataManager)
            okHttp.makeRequestWithOkHTTP {
                    val adapter = WeatherAdapter(dataManager.dataDaily)
                    binding.recyclerview.adapter = adapter
//              callBak(dataManager.dataList!!)
                }
        }

}