package com.geeks.mvvm15_1j.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Binding: ViewBinding> : Fragment() {
    private var _binding: Binding? = null
    protected val binding get() = _binding!!
    abstract fun getViewBinding(): Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        constructListeners()
        launchObserver()
    }

    protected open fun initialize() {}
    protected open fun launchObserver() {}
    protected open fun constructListeners() {}

}