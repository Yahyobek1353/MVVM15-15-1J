package com.geeks.mvvm15_1j.data.model

import com.geeks.mvvm15_1j.data.model.character.RickAndMortyCharacter

data class BaseMainResponse(
    val info: CharacterInfo,
    val results: List<RickAndMortyCharacter>
)