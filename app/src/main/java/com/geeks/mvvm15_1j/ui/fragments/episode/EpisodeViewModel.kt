package com.geeks.mvvm15_1j.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.mvvm15_1j.common.Resource
import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.model.RickAndMortyEpisode
import com.geeks.mvvm15_1j.data.network.service.ApiService
import com.geeks.mvvm15_1j.ui.App

class EpisodeViewModel:ViewModel() {
    var liveData = MutableLiveData<Resource<BaseMainResponse<RickAndMortyEpisode>?>>()
    fun getLocation(){
        liveData = App.episodeRepository.getEpisode()
    }
}