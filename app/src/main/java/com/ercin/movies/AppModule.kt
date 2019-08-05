package com.ercin.movies

import com.ercin.movies.ui.detail.MovieDetailViewModel
import com.ercin.movies.ui.main.movies.MovieListViewModel
import com.ercin.movies.util.DeviceUtils
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    //single { (get() as Retrofit).create(ApiService::class.java) }

    single { DeviceUtils(androidContext()) }
    viewModel { MovieListViewModel() }
    viewModel { (movieId: Int) -> MovieDetailViewModel(movieId) }
}