package com.ercin.movies.ui.main.movies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ercin.movies.base.BaseViewModel
import com.ercin.movies.data.remote.ApiClient
import com.ercin.movies.data.remote.ApiService
import com.ercin.movies.model.movie.MovieResult
import com.ercin.movies.ui.main.MovieAdapter
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.math.log

class MovieListViewModel() : BaseViewModel() {

    lateinit var popularMovieNavigatorInterface: PopularMovieAdapterNavigatorInterface

    val popularMoviesAdapter = MovieAdapter { moveId, movie ->
        popularMovieNavigatorInterface.goToMovieID(moveId)
    }

    fun requestPopularMovies() = viewModelScope.launch {
        Log.e("XXXX","startReq")
        popularMoviesAdapter.movies =ApiClient.getApiService().getPopularMovies(deviceUtils.local).results
        popularMovieNavigatorInterface.setAdapter(popularMoviesAdapter)
        Log.e("XXXX","finishReq")
    }

    fun setNavigator(nav: PopularMovieAdapterNavigatorInterface) {
        this.popularMovieNavigatorInterface = nav
    }
}