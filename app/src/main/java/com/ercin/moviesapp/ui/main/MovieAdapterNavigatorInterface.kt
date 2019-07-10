package com.ercin.moviesapp.ui.main

interface MovieAdapterNavigatorInterface {
    fun setMovieAdapter(adapter: MovieAdapter)
    fun goToMovieID(movieId:Int)
}