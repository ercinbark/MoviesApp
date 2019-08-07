package com.ercin.movies.base

import androidx.lifecycle.ViewModel
import com.ercin.movies.data.remote.ApiService
import com.ercin.movies.ui.main.MainRepository
import com.ercin.movies.util.DeviceUtils
import com.ercin.movies.widget.LoadingDialog
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseViewModel : ViewModel(),KoinComponent {
    val deviceUtils:DeviceUtils by inject()
    val mainRepository:MainRepository by inject()
}