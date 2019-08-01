package com.ercin.movies.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

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