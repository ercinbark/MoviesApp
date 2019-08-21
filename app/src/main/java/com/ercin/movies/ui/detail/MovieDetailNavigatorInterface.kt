package com.ercin.movies.ui.detail

import com.ercin.movies.model.detail.MovieDetailResponse
import com.ercin.movies.model.videos.MovieVideoResponse
import com.ercin.movies.model.videos.MovieVideoResults

interface MovieDetailNavigatorInterface {
    fun showMovieDetail(movieDetail:MovieDetailResponse)
    fun showMovieVideos(adapter: MovieVideosAdapter)
    fun showVideoPlayer(videoID:String)
}