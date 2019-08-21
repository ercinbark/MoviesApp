package com.ercin.movies.ui.main.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ercin.movies.base.BaseViewModel
import com.ercin.movies.ui.main.MovieAdapter
import kotlinx.coroutines.launch


class MovieListViewModel : BaseViewModel() {

    lateinit var popularMovieNavigatorInterface: MovieListAdapterNavigatorInterface
    val loading = MutableLiveData<Boolean>().apply { value = false }

    val popularMoviesAdapter = MovieAdapter { moveId, movie ->
        popularMovieNavigatorInterface.goToMovieDetail(moveId)
    }

    fun requestPopularMovies() = viewModelScope.launch {
        Log.e("XXXX", "startReqMovieList")

        loading.value = true

        popularMoviesAdapter.movies = mainRepository.getPopularMovies()
        popularMovieNavigatorInterface.setAdapter(popularMoviesAdapter)
        Log.e("XXXX", "finishReqMovieList")

        loading.value = false

    }

    fun setNavigator(nav: MovieListAdapterNavigatorInterface) {
        this.popularMovieNavigatorInterface = nav
    }

}