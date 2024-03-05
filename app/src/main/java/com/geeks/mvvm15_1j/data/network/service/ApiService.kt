package com.geeks.mvvm15_1j.data.network.service

import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.model.RickAndMortyEpisode
import com.geeks.mvvm15_1j.data.model.location.RickAndMortyLocation
import com.geeks.mvvm15_1j.data.model.character.RickAndMortyCharacter
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    fun getAllCharacter(): Call<BaseMainResponse<RickAndMortyCharacter>>
    @GET("location")
    fun getAllLocation(): Call<BaseMainResponse<RickAndMortyLocation>>

    @GET("episode")
    fun getAllEpisode(): Call<BaseMainResponse<RickAndMortyEpisode>>
}