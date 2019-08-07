package com.ercin.movies.ui.main

import androidx.lifecycle.MutableLiveData
import android.util.Log
import com.ercin.movies.data.remote.ApiClient
import com.ercin.movies.data.remote.ApiService
import com.ercin.movies.model.movie.MovieResponse
import com.ercin.movies.model.movie.MovieResult
import com.ercin.movies.util.DeviceUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(val deviceUtils: DeviceUtils) {

    suspend fun getPopularMovies():List<MovieResult> {
        return ApiClient.getApiService().getPopularMovies(deviceUtils.local).results
    }
}