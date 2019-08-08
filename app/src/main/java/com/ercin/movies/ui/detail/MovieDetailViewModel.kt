package com.ercin.movies.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ercin.movies.base.BaseViewModel
import com.ercin.movies.model.detail.MovieDetailResponse
import kotlinx.coroutines.launch

class MovieDetailViewModel(var movieId: Int) : BaseViewModel() {

    val loading = MutableLiveData<Boolean>().apply { value = false }
    lateinit var movieDetailResponse: MovieDetailResponse
    private lateinit var navigatorDetailInterface: MovieDetailNavigatorInterface

    fun requestMovieDetail() = viewModelScope.launch {
        Log.e("XXXX", "startReqMovieDetail")

        loading.value = true

        movieDetailResponse = mainRepository.getMovieDetail(movieId)
        navigatorDetailInterface.showMovieDetail(movieDetailResponse)
        Log.e("XXXX", "finishReqMovieDetail")

        loading.value = false

    }

    fun setDetailNavigator(nav: MovieDetailNavigatorInterface) {
        this.navigatorDetailInterface = nav
    }
}