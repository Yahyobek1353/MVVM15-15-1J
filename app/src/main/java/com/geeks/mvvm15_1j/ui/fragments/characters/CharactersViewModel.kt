package com.geeks.mvvm15_1j.ui.fragments.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.mvvm15_1j.common.Resource
import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.model.character.RickAndMortyCharacter
import com.geeks.mvvm15_1j.data.network.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {
    var liveData = MutableLiveData<Resource<BaseMainResponse<RickAndMortyCharacter>?>>()

    fun getCharacter(page: Int,name: String, status : String , gender : String, species : String){
        liveData = repository.getCharacter(page = page,name, status,gender,species)
    }

}