package com.ercin.moviesapp.ui.main.popular

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ercin.moviesapp.ui.main.MainRepository
import com.ercin.moviesapp.ui.main.MovieAdapter
import com.ercin.moviesapp.ui.main.MovieAdapterNavigatorInterface

class PopularMoviesViewModel : ViewModel() {

    private val repository: MainRepository by lazy { MainRepository() }
    private lateinit var navigatorInterface: MovieAdapterNavigatorInterface
    val moviesAdapter: MovieAdapter = MovieAdapter(MutableLiveData())

    fun updateAdapter() {
        moviesAdapter.movies = repository.getPopularMoviesList()
        navigatorInterface.setMovieAdapter(moviesAdapter)
        moviesAdapter.dataChangeObserve()
    }

    fun setNavigator(nav: MovieAdapterNavigatorInterface) {
        this.navigatorInterface = nav
    }

}
