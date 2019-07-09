package com.ercin.moviesapp.model.movie

import com.google.gson.annotations.SerializedName

class MovieResponse(
    @SerializedName("results")
    var results: List<MovieResult>
)