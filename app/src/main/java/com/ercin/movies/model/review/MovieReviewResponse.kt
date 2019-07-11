package com.ercin.movies.model.review

import com.google.gson.annotations.SerializedName

data class MovieReviewResponse (
    @SerializedName("id")
    var id:String,
    @SerializedName("results")
    var results:List<MovieReviewResults>
)