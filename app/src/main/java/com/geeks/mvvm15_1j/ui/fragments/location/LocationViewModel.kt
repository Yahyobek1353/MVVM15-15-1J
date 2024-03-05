package com.geeks.mvvm15_1j.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.mvvm15_1j.common.Resource
import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.model.location.RickAndMortyLocation
import com.geeks.mvvm15_1j.ui.App

class LocationViewModel : ViewModel() {
    var liveData = MutableLiveData<Resource<BaseMainResponse<RickAndMortyLocation>?>>()
    fun getLocation(){
        liveData = App.locationRepository.getLocation()
    }
}