package com.ercin.movies.ui.detail

import android.util.Log
import com.ercin.movies.base.BaseViewModel
import com.ercin.movies.data.remote.ApiClient
import com.ercin.movies.model.detail.MovieDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailViewModel(var movieId:Int) : BaseViewModel() {

    var apiService = ApiClient.getApiService()
    lateinit var movieDetaiResponse: MovieDetailResponse
    private lateinit var navigatorDetailInterface: MovieDetailNavigatorInterface

    fun requestMovieDetail() {
        Log.e("XXXX", deviceUtils.locale.toString())
        apiService.getMovieDetails(movieId, deviceUtils.local)
            .enqueue(object : Callback<MovieDetailResponse> {
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