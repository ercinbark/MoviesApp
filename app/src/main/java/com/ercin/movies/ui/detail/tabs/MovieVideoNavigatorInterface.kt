package com.ercin.movies.ui.detail.tabs

interface MovieVideoNavigatorInterface {
    fun showMovieVideoAdapter(adapter: MovieVideosAdapter)
    fun watchTrailerDialog(videoID:String)
}