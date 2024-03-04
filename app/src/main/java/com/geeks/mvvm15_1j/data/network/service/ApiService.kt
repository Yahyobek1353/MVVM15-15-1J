package com.geeks.mvvm15_1j.data.network.service

import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    fun getAllCharacter(): Call<BaseMainResponse>
    @GET("location")
    fun getAllLocation(): Call<BaseMainResponse>
}