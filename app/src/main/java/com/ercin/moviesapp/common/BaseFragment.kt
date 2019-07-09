package com.ercin.moviesapp.common

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment<DB : ViewDataBinding, VM : ViewModel> : Fragment() {

    lateinit var dataBinding: DB
    lateinit var viewModel: VM

    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun getViewModel(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(getViewModel())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        return dataBinding.root


    }

}