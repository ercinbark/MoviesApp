package com.ercin.movies.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

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