package com.ercin.movies.model.videos

import com.google.gson.annotations.SerializedName

data class MovieVideoResponse (
    @SerializedName("id")
    var id:String,
    @SerializedName("results")
    var results:List<MovieVideoResults>
)