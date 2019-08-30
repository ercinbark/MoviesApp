package com.ercin.movies

import com.ercin.movies.ui.detail.MovieDetailViewModel
import com.ercin.movies.ui.detail.tabs.MovieOverviewViewModel
import com.ercin.movies.ui.main.MainRepository
import com.ercin.movies.ui.main.movies.MovieListViewModel
import com.ercin.movies.util.DeviceUtils
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { DeviceUtils(androidContext()) }
    single { MainRepository(get()) }

    viewModel { MovieListViewModel() }
    viewModel { (movieId: Int) -> MovieDetailViewModel(movieId) }
    viewModel { (movieId: Int) -> MovieOverviewViewModel(movieId) }
}