package com.geeks.mvvm15_1j.data.model.character

import com.geeks.mvvm15_1j.data.model.RickAndMortyOrigin
import com.geeks.mvvm15_1j.data.model.location.RickAndMortyLocation

data class RickAndMortyCharacter(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: RickAndMortyOrigin? = null,
    val image: String,
    val location: RickAndMortyLocation
)