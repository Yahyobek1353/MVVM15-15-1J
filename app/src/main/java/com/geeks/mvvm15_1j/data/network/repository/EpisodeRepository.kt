package com.geeks.mvvm15_1j.data.network.repository

import androidx.lifecycle.MutableLiveData
import com.geeks.mvvm15_1j.common.Resource
import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.model.episode.RickAndMortyEpisode
import com.geeks.mvvm15_1j.data.network.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class EpisodeRepository @Inject constructor(private val apiService: ApiService) {
    fun getEpisode(): MutableLiveData<Resource<BaseMainResponse<RickAndMortyEpisode>?>> {
        val liveData =  MutableLiveData<Resource<BaseMainResponse<RickAndMortyEpisode>?>>()
        liveData.value = Resource.Loading()
        apiService.getAllEpisode()
            .enqueue(object : Callback<BaseMainResponse<RickAndMortyEpisode>?> {
                override fun onResponse(
                    call: Call<BaseMainResponse<RickAndMortyEpisode>?>,
                    response: Response<BaseMainResponse<RickAndMortyEpisode>?>
                ) {
                    if (response.isSuccessful && response.body() != null){
                        liveData.value = Resource.Success(data = response.body())
                    }
                }

                override fun onFailure(
                    call: Call<BaseMainResponse<RickAndMortyEpisode>?>,
                    t: Throwable
                ) {
                }

            })
        return liveData
    }
}