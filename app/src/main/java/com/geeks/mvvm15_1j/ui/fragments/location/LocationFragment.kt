package com.geeks.mvvm15_1j.ui.fragments.location

import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.geeks.mvvm15_1j.common.Resource
import com.geeks.mvvm15_1j.core.BaseFragment
import com.geeks.mvvm15_1j.databinding.FragmentLocationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment : BaseFragment<FragmentLocationBinding>() {
    override fun getViewBinding() = FragmentLocationBinding.inflate(layoutInflater)
    private val adapter: LocationAdapter by lazy { LocationAdapter() }
    private val viewModel: LocationViewModel by lazy { ViewModelProvider(requireActivity())[LocationViewModel::class.java] }


    override fun initialize() {
        binding.rvLocation.adapter = adapter
        viewModel.getLocation()
    }
    override fun launchObserver() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            when(it){
                is Resource.Loading -> binding.progressBarLocation.isVisible = true
                is Resource.Success -> {
                    binding.progressBarLocation.isGone = true
                    it.data?.results?.let { it2 -> adapter.setLocation(it2) }
                }
                is Resource.Error-> {
                    binding.progressBarLocation.isGone = true
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
