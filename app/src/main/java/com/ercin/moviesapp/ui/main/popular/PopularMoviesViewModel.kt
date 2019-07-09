package com.ercin.moviesapp.ui.main.popular

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ercin.moviesapp.ui.main.MainRepository
import com.ercin.moviesapp.ui.main.MovieAdapter
import com.ercin.moviesapp.ui.main.MovieAdapterNavigatorInterface

class PopularMoviesViewModel : ViewModel() {

    private val repository: MainRepository by lazy { MainRepository() }
    private lateinit var navigator: MovieAdapterNavigatorInterface
    val moviesAdapter: MovieAdapter = MovieAdapter(MutableLiveData())

    fun updateAdapter() {
        navigator.setAdapter(moviesAdapter)
        moviesAdapter.movies = repository.getPopularMoviesList()
        moviesAdapter.dataChangeObserve()
    }

    fun setNavigator(nav: MovieAdapterNavigatorInterface) {
        this.navigator = nav
    }

}
