package com.geeks.mvvm15_1j.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geeks.mvvm15_1j.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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