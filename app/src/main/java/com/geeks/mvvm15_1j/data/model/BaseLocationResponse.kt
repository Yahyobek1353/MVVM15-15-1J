package com.geeks.mvvm15_1j.data.model

data class BaseLocationResponse(
    val info: CharacterInfo,
    val results: List<RickAndMortyLocation>
)