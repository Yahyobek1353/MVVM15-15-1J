package com.geeks.mvvm15_1j.data.network.service

import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.model.episode.RickAndMortyEpisode
import com.geeks.mvvm15_1j.data.model.location.RickAndMortyLocation
import com.geeks.mvvm15_1j.data.model.character.RickAndMortyCharacter
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    fun getAllCharacter(
        @Query("page") page: Int? = 1,
        @Query("name") name: String? = null,
        @Query("status") status: String? = null,
        @Query("gender") gender: String? = null,
        @Query("species") species: String? = null
    ): Call<BaseMainResponse<RickAndMortyCharacter>>
    @GET("location")
    fun getAllLocation(): Call<BaseMainResponse<RickAndMortyLocation>>

    @GET("episode")
    fun getAllEpisode(): Call<BaseMainResponse<RickAndMortyEpisode>>
}