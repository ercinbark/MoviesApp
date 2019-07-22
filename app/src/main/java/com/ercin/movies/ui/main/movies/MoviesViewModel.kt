package com.ercin.movies.ui.main.movies

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.ercin.movies.data.remote.ApiClient
import com.ercin.movies.model.movie.MovieResponse
import com.ercin.movies.model.movie.MovieResult
import com.ercin.movies.ui.main.MovieAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel : ViewModel() {

    lateinit var popularMovieNavigatorInterface: PopularMovieAdapterNavigatorInterface

    val popularMoviesAdapter = MovieAdapter { moveId, movie ->
        popularMovieNavigatorInterface.goToMovieID(moveId)
    }

    fun requestPopularMovies() {
        ApiClient.getApiService().getPopularMovies().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("Resp", t.message)
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                Log.e("Resp", response.body().toString())
                popularMoviesAdapter.movies=response.body()?.results!!
                popularMovieNavigatorInterface.setAdapter(popularMoviesAdapter)

            }
        })
    }

    fun setNavigator(nav: PopularMovieAdapterNavigatorInterface) {
        this.popularMovieNavigatorInterface = nav
    }
}