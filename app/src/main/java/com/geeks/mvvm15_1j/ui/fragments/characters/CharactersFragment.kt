package com.geeks.mvvm15_1j.ui.fragments.characters

import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.geeks.mvvm15_1j.common.Resource
import com.geeks.mvvm15_1j.core.BaseFragment
import com.geeks.mvvm15_1j.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {
    override fun getViewBinding() = FragmentCharactersBinding.inflate(layoutInflater)
    private val adapter: CharacterAdapter by lazy { CharacterAdapter() }
    private val viewModel:CharactersViewModel by lazy { ViewModelProvider(requireActivity())[CharactersViewModel::class.java] }

    override fun initialize() {
        var name : String = " "
        binding.rvCharacters.adapter = adapter
        viewModel.getCharacter("")
    }

    override fun constructListeners() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    viewModel.liveData.observe(viewLifecycleOwner) {
                        when (it) {
                            is Resource.Loading -> {
                                binding.progressBar.isVisible = true
                                binding.rvCharacters.isVisible = false
                            }
                            is Resource.Success -> {
                                binding.progressBar.isGone = true
                                binding.rvCharacters.isVisible = true
                                binding.rvCharacters.animate().alpha(0f)
                                binding.rvCharacters.animate().alpha(1f).startDelay = 6000
                                viewModel.getCharacter(newText)
                                it.data?.results?.let { it1 -> adapter.setCharacter(it1) }
                            }
                            is Resource.Error -> {
                                binding.progressBar.isGone = true
                                binding.rvCharacters.isVisible = true
                                Toast.makeText(
                                    requireContext(),
                                    "Упс! Произошла какая-то ошибка",
                                    Toast.LENGTH_SHORT
                                ).show()
                                Log.e("ololo", "Error")
                            }
                        }
                    }
                }
                return true
            }
        })
    }

    override fun launchObserver() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> binding.progressBar.isVisible = true
                is Resource.Success -> {
                    binding.progressBar.isGone = true
                    it.data?.results?.let { it1 -> adapter.setCharacter(it1) }
                }
                is Resource.Error -> {
                    binding.progressBar.isGone = true
                    Toast.makeText(
                        requireContext(),
                        "Упс! Произошла какая-то ошибка",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
