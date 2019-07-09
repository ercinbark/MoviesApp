package com.ercin.moviesapp.ui.main.popular

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ercin.moviesapp.ui.main.MainRepository
import com.ercin.moviesapp.ui.main.MovieAdapter

class PopularMoviesViewModel : ViewModel() {

    private val repository: MainRepository by lazy { MainRepository() }
    private lateinit var navigator: PopularMoviesNavigator
    val moviesAdapter: MovieAdapter = MovieAdapter(MutableLiveData())

    fun updateAdapter() {
        navigator.setAdapter(moviesAdapter)
        moviesAdapter.movies = repository.getPopularMoviesList()
        moviesAdapter.observe()

    }

    fun setNavigator(nav: PopularMoviesNavigator) {
        this.navigator = nav
    }


}

interface PopularMoviesNavigator {
    fun setAdapter(adapter: MovieAdapter)
}