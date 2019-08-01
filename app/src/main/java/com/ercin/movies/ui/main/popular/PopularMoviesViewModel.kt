package com.ercin.movies.ui.main.popular

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ercin.movies.ui.main.MainRepository
import com.ercin.movies.ui.main.MovieAdapter
import com.ercin.movies.ui.main.MovieAdapterNavigatorInterface

class PopularMoviesViewModel : ViewModel() {

    private val repository: MainRepository by lazy { MainRepository() }
    private lateinit var navigatorInterface: MovieAdapterNavigatorInterface

    /*val moviesAdapter: MovieAdapter = MovieAdapter(MutableLiveData()) { movieId, movie ->
        navigatorInterface.goToMovieID(movieId)
    }

    fun updateAdapter() {
        moviesAdapter.movies = repository.getPopularMoviesList()
        navigatorInterface.setMovieAdapter(moviesAdapter)
        moviesAdapter.dataChangeObserve()
    }

    fun setNavigator(nav: MovieAdapterNavigatorInterface) {
        this.navigatorInterface = nav
    }*/

}
