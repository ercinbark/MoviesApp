package com.ercin.moviesapp.model.detail

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("id")
    var id:String,
    @SerializedName("backdrop_path")
    var backdrop_path:String,
    @SerializedName("overview")
    var overview:String,
    @SerializedName("poster_path")
    var poster_path:String,
    @SerializedName("release_date")
    var release_date:String,
    @SerializedName("title")
    var titlee:String,
    @SerializedName("video")
    var video:Boolean,
    @SerializedName("vote_average")
    var vote_average:Double,
    @SerializedName("vote_count")
    var vote_count:Int

)