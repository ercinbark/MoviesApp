package com.ercin.movies.ui.main

interface MovieAdapterNavigatorInterface {
    fun setMovieAdapter(adapter: MovieAdapter)
    fun goToMovieID(movieId:Int)
}