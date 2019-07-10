package com.ercin.moviesapp.ui.detail

import com.ercin.moviesapp.model.detail.MovieDetailResponse

interface MovieDetailNavigatorInterface {
    fun showMovieDetail(movieDetail:MovieDetailResponse)
}