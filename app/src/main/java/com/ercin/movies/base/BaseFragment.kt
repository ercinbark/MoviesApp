package com.ercin.movies.base

import androidx.fragment.app.Fragment

abstract class BaseFragment :Fragment() {

    fun getBaseActivity(): BaseActivity {
        return activity as BaseActivity
    }
}