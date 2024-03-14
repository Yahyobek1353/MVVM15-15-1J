package com.geeks.mvvm15_1j.ui.fragments.characters

import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.geeks.mvvm15_1j.R
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

    private var page = 1

    override fun initialize() {
        binding.rvCharacters.adapter = adapter
        viewModel.getCharacter(page, "" , "", "", "")
    }

    override fun constructListeners() {
        binding.btnLoadMore.setOnClickListener{
            page++
            viewModel.liveData.observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {
                        binding.progressBar.isVisible = true
                        binding.rvCharacters.isVisible = false
                    }
                    is Resource.Success -> {
                        binding.progressBar.isGone = true
                        binding.rvCharacters.isVisible = true
                        viewModel.getCharacter(page = page, "unknown", "", "", "")
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
        binding.btnFilter.setOnClickListener{
            if (binding.radioGroup.isVisible){
                binding.radioGroup.isGone = true
            }else{
                binding.radioGroup.isVisible = true
            }
        }
        //---------------------------------------------------------------------------------
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId){
                R.id.status_btn -> {
                    binding.statusRadioGroup.isVisible = true
                }
                R.id.type_btn ->{
                    binding.statusRadioGroup.isGone = true
                }
                R.id.gender_btn -> {
                    binding.statusRadioGroup.isGone = true
                }
            }

        }

        //------------------------------------------------------------------------------------
        binding.statusRadioGroup.setOnCheckedChangeListener{ _, index->
            when (index){
                R.id.alive_btn ->{
                    ServerInfo(page , "" , "Alive")
                    binding.statusRadioGroup.isGone = true
                }
                R.id.dead_btn->{
                    ServerInfo(page , "","Dead")
                    binding.statusRadioGroup.isGone = true
                }
                R.id.unknown_btn->{
                    ServerInfo(page , "","unknown")
                    binding.statusRadioGroup.isGone = true
                }
            }
        }


        //------------------------------------------------------------------------------------
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    ServerInfo(page , newText , "")
                }
                return true
            }
        })
    }

    override fun launchObserver() {
       ServerInfo(page,"","")
    }


    private fun ServerInfo(page :Int,name : String , status:String){
        viewModel.liveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> binding.progressBar.isVisible = true
                is Resource.Success -> {
                    binding.progressBar.isGone = true
                    viewModel.getCharacter(page = page, name= name, status = status, "", "")
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
