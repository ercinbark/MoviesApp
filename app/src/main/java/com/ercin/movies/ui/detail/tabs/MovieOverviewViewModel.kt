package com.ercin.movies.ui.detail.tabs

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.ercin.movies.base.BaseViewModel
import kotlinx.coroutines.launch

class MovieOverviewViewModel(var movieId: Int) : BaseViewModel() {

    lateinit var movieVideosNavigator: MovieVideoNavigatorInterface

    var videoAdapter: MovieVideosAdapter =
        MovieVideosAdapter { movieVideoId ->
            Log.e("YYYY", "Send VideoID : $movieVideoId")
            movieVideosNavigator.watchTrailerDialog(movieVideoId)
        }

    fun requestMovieVideos() = viewModelScope.launch {
        Log.e("YYYY", "reqStartMovieVideo")
        videoAdapter.moviesVideoList = mainRepository.getMoviesVideos(movieId)
        movieVideosNavigator.showMovieVideoAdapter(videoAdapter)
        Log.e("YYYY", "reqFinishMovieVideo")

    }

    fun setMovieVideoNavigator(navVideo: MovieVideoNavigatorInterface) {
        this.movieVideosNavigator = navVideo
    }

}