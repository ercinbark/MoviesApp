package com.ercin.movies.data.remote

import com.ercin.movies.model.detail.MovieDetailResponse
import com.ercin.movies.model.movie.MovieResponse
import com.ercin.movies.model.review.MovieReviewResponse
import com.ercin.movies.model.videos.MovieVideoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    //Popular
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("language") language: String): MovieResponse

    //MovieDetail
    @GET("movie/{id}")
    suspend fun getMovieDetails(@Path("id") movieId: Int, @Query("language") language: String): MovieDetailResponse

    //TopRated
    @GET("movie/top_rated")
    fun getTopRatedMovies(): Call<MovieResponse>

    //Videos
    @GET("movie/{id}/videos")
    fun getMovieVideos(@Path("id") movieId: Int): Call<MovieVideoResponse>

    //Reviews
    @GET("movie/{id}/reviews")
    fun getMovieRewiews(@Path("id") movieId: Int): Call<MovieReviewResponse>

}