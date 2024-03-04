package com.geeks.mvvm15_1j

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geeks.mvvm15_1j.databinding.ActivityMainBinding
import com.geeks.mvvm15_1j.ui.ViewPagerAdapter
import com.geeks.mvvm15_1j.ui.fragments.EpisodFragment
import com.geeks.mvvm15_1j.ui.fragments.characters.CharactersFragment
import com.geeks.mvvm15_1j.ui.fragments.location.LocationFragment
import com.google.android.material.tabs.TabLayoutMediator

@Suppress("UNCHECKED_CAST")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val fragList = listOf(
        LocationFragment.newInstance(),
        CharactersFragment.newInstance(),
        EpisodFragment.newInstance()
    )
    private val tabName= listOf(
        "Location",
        "Character",
        "Episode"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = ViewPagerAdapter(supportFragmentManager , lifecycle)
        binding.VeiwPager.adapter = adapter
        TabLayoutMediator(binding.tab,binding.VeiwPager){
            tab,pos->
            when (pos){
                0->{
                    tab.text="Location"
                }
                1->{
                    tab.text = "Character"
                }
                2->{
                    tab.text = "Episode"
                }
            }
        }.attach()
    }


}