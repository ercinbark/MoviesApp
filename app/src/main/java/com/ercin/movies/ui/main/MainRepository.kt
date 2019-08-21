package com.ercin.movies.ui.main

import com.ercin.movies.data.remote.ApiClient
import com.ercin.movies.model.detail.MovieDetailResponse
import com.ercin.movies.model.movie.MovieResult
import com.ercin.movies.model.videos.MovieVideoResults
import com.ercin.movies.util.DeviceUtils

class MainRepository(val deviceUtils: DeviceUtils) {

    suspend fun getPopularMovies(): List<MovieResult> {
        return ApiClient.getApiService().getPopularMovies(deviceUtils.local).results
    }

    suspend fun getMovieDetail(movieId: Int): MovieDetailResponse {
        return ApiClient.getApiService().getMovieDetails(movieId,deviceUtils.local)
    }

    suspend fun getMoviesVideos(movieId: Int):List<MovieVideoResults>{
        return ApiClient.getApiService().getMovieVideos(movieId,"en").results
    }
}