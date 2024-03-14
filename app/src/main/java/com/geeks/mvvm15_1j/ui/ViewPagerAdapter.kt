package com.geeks.mvvm15_1j.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.geeks.mvvm15_1j.ui.fragments.characters.CharactersFragment
import com.geeks.mvvm15_1j.ui.fragments.episode.EpisodeFragment
import com.geeks.mvvm15_1j.ui.fragments.location.LocationFragment


class ViewPagerAdapter(fragment: FragmentManager, lifecycle : Lifecycle) : FragmentStateAdapter(fragment,lifecycle){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                LocationFragment()
            }
            1 -> {
                CharactersFragment()
            }
            2 ->{
                EpisodeFragment()
            }
            else->{
                Fragment()
            }
        }
    }

}