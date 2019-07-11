package com.ercin.movies.model.movie

import com.google.gson.annotations.SerializedName

class MovieResponse(
    @SerializedName("results")
    var results: List<MovieResult>
)