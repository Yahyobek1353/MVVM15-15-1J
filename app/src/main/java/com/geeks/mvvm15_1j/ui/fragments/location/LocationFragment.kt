package com.geeks.mvvm15_1j.ui.fragments.location

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.geeks.mvvm15_1j.R
import com.geeks.mvvm15_1j.core.BaseFragment
import com.geeks.mvvm15_1j.data.model.BaseLocationResponse
import com.geeks.mvvm15_1j.data.model.BaseMainResponse
import com.geeks.mvvm15_1j.data.network.service.ApiService
import com.geeks.mvvm15_1j.data.network.service.RetrofitClient
import com.geeks.mvvm15_1j.databinding.FragmentCharactersBinding
import com.geeks.mvvm15_1j.databinding.FragmentLocationBinding
import com.geeks.mvvm15_1j.ui.fragments.characters.CharacterAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationFragment : BaseFragment<FragmentLocationBinding>() {
    override fun getViewBinding() = FragmentLocationBinding.inflate(layoutInflater)

    private val adapter: LocationAdapter by lazy { LocationAdapter() }

    override fun initialize() {
        binding.rvCharacters.adapter = adapter
    }

    override fun launchObserver() {
        val retrofit = RetrofitClient.retrofitInstance.create(ApiService::class.java)
        retrofit.getAllLocation().enqueue(object : Callback<BaseLocationResponse>{
            override fun onResponse(
                call: Call<BaseLocationResponse>,
                response: Response<BaseLocationResponse>
            ) {
                Toast.makeText(requireContext(), "1", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<BaseLocationResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "2", Toast.LENGTH_SHORT).show()
            }


        })
    }

    companion object{
        fun newInstance() = LocationFragment
    }
}
