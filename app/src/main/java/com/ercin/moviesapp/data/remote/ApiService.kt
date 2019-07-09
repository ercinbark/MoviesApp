package com.ercin.moviesapp.data.remote

import com.ercin.moviesapp.model.detail.MovieDetailResponse
import com.ercin.moviesapp.model.movie.MovieResponse
import com.ercin.moviesapp.model.review.MovieReviewResponse
import com.ercin.moviesapp.model.videos.MovieVideoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    //Popular
    @GET("movie/popular")
    fun getPopularMovies(): Call<MovieResponse>

    //TopRated
    @GET("movie/top_rated")
    fun getTopRatedMovies(): Call<MovieResponse>

    //MovieDetail
    @GET("movie/{id}")
    fun getMovieDetails(@Path("id")movieId:Int):Call<MovieDetailResponse>

    //Videos
    @GET("movie/{id}/videos")
    fun getMovieVideos(@Path("id")movieId: Int):Call<MovieVideoResponse>

    //Reviews
    @GET("movie/{id}/reviews")
    fun getMovieRewiews(@Path("id")movieId: Int):Call<MovieReviewResponse>

}