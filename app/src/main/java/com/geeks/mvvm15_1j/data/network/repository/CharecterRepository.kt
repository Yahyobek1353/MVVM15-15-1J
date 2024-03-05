package com.geeks.mvvm15_1j.data.network.repository

import androidx.lifecycle.MutableLiveData
import com.geeks.mvvm15_1j.common.Resource
import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.model.character.RickAndMortyCharacter
import com.geeks.mvvm15_1j.data.network.service.ApiService
import com.geeks.mvvm15_1j.data.network.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class CharecterRepository(private val apiService: ApiService) {
    fun getCharacter(): MutableLiveData<Resource<BaseMainResponse<RickAndMortyCharacter>?>> {
        val liveData = MutableLiveData<Resource<BaseMainResponse<RickAndMortyCharacter>?>>()
        liveData.value = Resource.Loading()
        apiService.getAllCharacter()
            .enqueue(object : Callback<BaseMainResponse<RickAndMortyCharacter>?> {
                override fun onResponse(
                    call: Call<BaseMainResponse<RickAndMortyCharacter>?>,
                    response: Response<BaseMainResponse<RickAndMortyCharacter>?>
                ) {
                    if (response.isSuccessful && response.body() != null){
                        liveData.value = Resource.Success(data = response.body())
                    }
                }

                override fun onFailure(
                    call: Call<BaseMainResponse<RickAndMortyCharacter>?>,
                    t: Throwable
                ) {

                }


            })
        return liveData
    }
}