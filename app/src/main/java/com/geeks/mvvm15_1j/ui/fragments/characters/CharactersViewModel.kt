package com.geeks.mvvm15_1j.ui.fragments.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.mvvm15_1j.common.Resource
import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.model.character.RickAndMortyCharacter
import com.geeks.mvvm15_1j.ui.App

class CharactersViewModel: ViewModel() {
    var liveData = MutableLiveData<Resource<BaseMainResponse<RickAndMortyCharacter>?>>()
    fun getCharacter(){
        liveData = App.charecterRepository.getCharacter()
    }
}