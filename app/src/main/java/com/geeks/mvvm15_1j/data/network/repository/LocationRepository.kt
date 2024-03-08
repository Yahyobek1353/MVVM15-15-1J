package com.geeks.mvvm15_1j.data.network.repository

import androidx.lifecycle.MutableLiveData
import com.geeks.mvvm15_1j.common.Resource
import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.model.location.RickAndMortyLocation
import com.geeks.mvvm15_1j.data.network.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LocationRepository @Inject constructor(private val apiService: ApiService) {
    fun getLocation():MutableLiveData<Resource<BaseMainResponse<RickAndMortyLocation>?>>{
        val liveData =  MutableLiveData<Resource<BaseMainResponse<RickAndMortyLocation>?>>()
        liveData.value = Resource.Loading()
        apiService.getAllLocation()
            .enqueue(object : Callback<BaseMainResponse<RickAndMortyLocation>?>{
                override fun onResponse(
                    call: Call<BaseMainResponse<RickAndMortyLocation>?>,
                    response: Response<BaseMainResponse<RickAndMortyLocation>?>
                ) {
                    if (response.isSuccessful && response.body() != null){
                        liveData.value = Resource.Success(data = response.body())
                    }
                }

                override fun onFailure(
                    call: Call<BaseMainResponse<RickAndMortyLocation>?>,
                    t: Throwable
                ) {
                }

            })
        return liveData
    }
}