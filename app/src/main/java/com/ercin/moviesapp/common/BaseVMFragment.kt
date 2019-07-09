package com.ercin.moviesapp.common

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment

abstract class BaseVMFragment<VM:ViewModel>:Fragment() {

    lateinit var viewModel: VM

    abstract fun getViewModel(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(getViewModel())
    }
}