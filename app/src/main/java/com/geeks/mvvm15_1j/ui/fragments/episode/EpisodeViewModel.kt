package com.geeks.mvvm15_1j.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.mvvm15_1j.common.Resource
import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.model.episode.RickAndMortyEpisode
import com.geeks.mvvm15_1j.data.network.repository.EpisodeRepository
import com.geeks.mvvm15_1j.ui.App
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val repository: EpisodeRepository
)
    :ViewModel() {
    var liveData = MutableLiveData<Resource<BaseMainResponse<RickAndMortyEpisode>?>>()
    fun getLocation(){
        liveData = repository.getEpisode()
    }
}