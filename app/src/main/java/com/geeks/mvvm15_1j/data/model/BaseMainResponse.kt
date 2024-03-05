package com.geeks.mvvm15_1j.data.model

import com.geeks.mvvm15_1j.data.model.character.RickAndMortyCharacter

data class BaseMainResponse<T>(
    val info: CharacterInfo,
    val results: List<T>
)