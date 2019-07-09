package com.ercin.moviesapp.common

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<DB:ViewDataBinding,VM:ViewModel> :AppCompatActivity(){

    lateinit var dataBinding: DB
    lateinit var viewModel:VM

    @LayoutRes
    abstract fun getLayoutRes():Int

    abstract fun getViewModel():Class<VM>

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        dataBinding=DataBindingUtil.setContentView(this,getLayoutRes())
        viewModel=ViewModelProviders.of(this).get(getViewModel())

    }
}