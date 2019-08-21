package com.ercin.movies.ui.detail

import android.annotation.SuppressLint
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.ercin.movies.R
import com.ercin.movies.base.BaseActivity
import com.ercin.movies.databinding.ActivityMovieDetailBinding
import com.ercin.movies.model.detail.MovieDetailResponse
import kotlinx.android.synthetic.main.activity_movie_detail.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class MovieDetailActivity : BaseActivity(), MovieDetailNavigatorInterface {


    private var movieDetailId: Int = 0
    val viewModelMovieDetail: MovieDetailViewModel by viewModel { parametersOf(movieDetailId) }
    lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)

        movieDetailId = intent.getIntExtra("movieID", 0)
        Log.e("XXXX", "" + movieDetailId)
        viewModelMovieDetail.setDetailNavigator(this)
        viewModelMovieDetail.requestMovieDetail()

    }

    override fun showMovieDetail(movieDetail: MovieDetailResponse) {
        Log.e("XXXX", movieDetail.title)
        binding.movieDetail = movieDetail
    }

    @SuppressLint("WrongConstant")
    override fun showMovieVideos(adapter: MovieVideosAdapter) {
        val layoutManagerMovieVideo = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcMovieVideo.layoutManager = layoutManagerMovieVideo
        rcMovieVideo.adapter = adapter
    }

    override fun showVideoPlayer(videoID: String) {
        Log.e("YYYY","Step-1 VideoID $videoID")
        val videoDialog = MovieYoutubePlayerDialog.showMovieYoutubePlayerDialog(videoId = videoID)
        videoDialog.show(supportFragmentManager, "videoDialog")
    }

}
