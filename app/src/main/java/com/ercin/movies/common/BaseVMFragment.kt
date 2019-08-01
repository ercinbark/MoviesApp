package com.ercin.movies.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseVMFragment<VM:ViewModel>: Fragment() {

    lateinit var viewModel: VM

    abstract fun getViewModel(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(getViewModel())
    }
}