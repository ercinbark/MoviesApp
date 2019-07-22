package com.ercin.movies.ui.main.movies

import com.ercin.movies.ui.main.MovieAdapter

interface PopularMovieAdapterNavigatorInterface {
    fun setAdapter(adapter:MovieAdapter)
    fun goToMovieID(moveiID:Int)
}