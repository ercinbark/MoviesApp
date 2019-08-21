package com.ercin.movies.ui.main.movies

import com.ercin.movies.ui.main.MovieAdapter

interface MovieListAdapterNavigatorInterface {
    fun setAdapter(adapter:MovieAdapter)
    fun goToMovieDetail(moveiID:Int)
}