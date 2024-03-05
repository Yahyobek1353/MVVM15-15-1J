package com.geeks.mvvm15_1j.ui.fragments.episode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geeks.mvvm15_1j.R
import com.geeks.mvvm15_1j.core.BaseFragment
import com.geeks.mvvm15_1j.databinding.FragmentCharactersBinding
import com.geeks.mvvm15_1j.databinding.FragmentEpisodBinding
import com.geeks.mvvm15_1j.ui.fragments.characters.CharacterAdapter
import com.geeks.mvvm15_1j.ui.fragments.characters.CharactersFragment

class EpisodFragment : BaseFragment<FragmentEpisodBinding>() {
    override fun getViewBinding() = FragmentEpisodBinding.inflate(layoutInflater)


}