package com.ercin.movies.ui.detail

import com.ercin.movies.model.detail.MovieDetailResponse

interface MovieDetailNavigatorInterface {
    fun showMovieDetail(movieDetail:MovieDetailResponse)
}