package com.ercin.movies.base

import androidx.fragment.app.Fragment

open class BaseFragment :Fragment() {

    fun getBaseActivity(): BaseActivity {
        return activity as BaseActivity
    }
}