package com.geeks.mvvm15_1j.ui.fragments.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.mvvm15_1j.common.Resource
import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.model.character.RickAndMortyCharacter
import com.geeks.mvvm15_1j.data.network.repository.CharecterRepository
import com.geeks.mvvm15_1j.ui.App
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharecterRepository
) : ViewModel() {
    var liveData = MutableLiveData<Resource<BaseMainResponse<RickAndMortyCharacter>?>>()

    fun getCharacter(name: String){
        liveData = repository.getCharacter(name)
    }

}