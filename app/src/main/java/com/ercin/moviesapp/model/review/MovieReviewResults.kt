package com.ercin.moviesapp.model.review

import com.google.gson.annotations.SerializedName

data class MovieReviewResults(
    @SerializedName("id")
    var id:String,
    @SerializedName("author")
    var author:String,
    @SerializedName("content")
    var content:String

)