package com.geeks.mvvm15_1j.data.network.repository

import androidx.lifecycle.MutableLiveData
import com.geeks.mvvm15_1j.common.Resource
import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.model.character.RickAndMortyCharacter
import com.geeks.mvvm15_1j.data.network.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CharecterRepository @Inject constructor(private val apiService: ApiService) {
    fun getCharacter(name: String): MutableLiveData<Resource<BaseMainResponse<RickAndMortyCharacter>?>> {
        val liveData = MutableLiveData<Resource<BaseMainResponse<RickAndMortyCharacter>?>>()
        liveData.value = Resource.Loading()
        apiService.getAllCharacter(name = name)
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