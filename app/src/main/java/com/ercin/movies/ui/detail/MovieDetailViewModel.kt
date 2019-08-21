package com.ercin.movies.ui.detail

import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ercin.movies.base.BaseViewModel
import com.ercin.movies.model.detail.MovieDetailResponse
import com.ercin.movies.model.videos.MovieVideoResponse
import com.ercin.movies.model.videos.MovieVideoResults
import kotlinx.coroutines.launch

class MovieDetailViewModel(var movieId: Int) : BaseViewModel() {

    val loading = MutableLiveData<Boolean>().apply { value = false }
    lateinit var movieDetailResponse: MovieDetailResponse
    lateinit var movieVideoList: List<MovieVideoResults>
    private lateinit var navigatorDetailInterface: MovieDetailNavigatorInterface

    var adapter: MovieVideosAdapter = MovieVideosAdapter { movieVideoId ->
        Log.e("YYYY", "Send VideoID : $movieVideoId")
        navigatorDetailInterface.showVideoPlayer(movieVideoId)

    }

    fun requestMovieDetail() = viewModelScope.launch {
        loading.value = true
        Log.e("XXXX", "startReqMovieDetail")

        movieDetailResponse = mainRepository.getMovieDetail(movieId)
        navigatorDetailInterface.showMovieDetail(movieDetailResponse)
        Log.e("XXXX", "finishReqMovieDetail")

        Log.e("XXXX", "startReqVideo")
        movieVideoList = mainRepository.getMoviesVideos(movieId)
        adapter.moviesVideoList = movieVideoList
        navigatorDetailInterface.showMovieVideos(adapter)
        Log.e("XXXX", "finishReqVideo")
        loading.value = false
    }

    fun setDetailNavigator(nav: MovieDetailNavigatorInterface) {
        this.navigatorDetailInterface = nav
    }

}