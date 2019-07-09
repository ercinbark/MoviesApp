package com.ercin.moviesapp.ui.main

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.ercin.moviesapp.data.remote.ApiClient
import com.ercin.moviesapp.data.remote.ApiService
import com.ercin.moviesapp.model.movie.MovieResponse
import com.ercin.moviesapp.model.movie.MovieResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {
    private val apiService: ApiService by lazy { ApiClient.getApiService() }

    fun getPopularMoviesList(): MutableLiveData<List<MovieResult>> { val moviesLiveData: MutableLiveData<List<MovieResult>> = MutableLiveData()

        apiService.getPopularMovies().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("getPopularMovies", t.message)
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                moviesLiveData.value = response.body()?.results
            }
        })

        return moviesLiveData
    }


    fun getTopRatedMovies() {

    }
}