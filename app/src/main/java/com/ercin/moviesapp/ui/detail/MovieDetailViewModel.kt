package com.ercin.moviesapp.ui.detail

import android.arch.lifecycle.ViewModel
import com.ercin.moviesapp.data.remote.ApiClient
import com.ercin.moviesapp.model.detail.MovieDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailViewModel() : ViewModel() {

    var movieDetailId: Int = 0
    var apiService = ApiClient.getApiService()
    lateinit var movieDetaiResponse: MovieDetailResponse
    private lateinit var navigatorDetailInterface: MovieDetailNavigatorInterface

    fun requestMovieDetail() {
        apiService.getMovieDetails(movieDetailId).enqueue(object : Callback<MovieDetailResponse> {
            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieDetailResponse>, response: Response<MovieDetailResponse>) {
                if (response.body() != null) {
                    movieDetaiResponse = response.body()!!
                    navigatorDetailInterface.showMovieDetail(movieDetaiResponse)
                }
            }
        })
    }

    fun setDetailNavigator(nav: MovieDetailNavigatorInterface) {
        this.navigatorDetailInterface = nav
    }
}