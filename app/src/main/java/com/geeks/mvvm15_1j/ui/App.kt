package com.geeks.mvvm15_1j.ui

import android.app.Application
import com.geeks.mvvm15_1j.data.model.RickAndMortyEpisode
import com.geeks.mvvm15_1j.data.network.repository.CharecterRepository
import com.geeks.mvvm15_1j.data.network.repository.EpisodeRepository
import com.geeks.mvvm15_1j.data.network.repository.LocationRepository
import com.geeks.mvvm15_1j.data.network.service.ApiService
import com.geeks.mvvm15_1j.data.network.service.RetrofitClient
import retrofit2.create

class App: Application() {
    companion object {
        lateinit var episodeRepository: EpisodeRepository
        lateinit var charecterRepository: CharecterRepository
        lateinit var locationRepository: LocationRepository
    }

    override fun onCreate() {
        super.onCreate()
        val apiService = RetrofitClient.retrofitInstance.create(ApiService::class.java)
        locationRepository = LocationRepository(apiService)
        episodeRepository = EpisodeRepository(apiService)
        charecterRepository = CharecterRepository(apiService)
    }
}