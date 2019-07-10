package com.ercin.moviesapp.ui.detail

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.ercin.moviesapp.R
import com.ercin.moviesapp.databinding.ActivityMovieDetailBinding
import com.ercin.moviesapp.model.detail.MovieDetailResponse
import com.ercin.moviesapp.util.Constant
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity(), MovieDetailNavigatorInterface {

    lateinit var viewModel: MovieDetailViewModel
    lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        viewModel = ViewModelProviders.of(this).get(MovieDetailViewModel::class.java)

        viewModel.movieDetailId = intent.getIntExtra("movieID", 0)

        viewModel.setDetailNavigator(this)
        viewModel.requestMovieDetail()
        ppBar.visibility= View.VISIBLE


    }

    override fun showMovieDetail(movieDetail: MovieDetailResponse) {
        Log.e("movieTitle", movieDetail.titlee)
        binding.movieDetail = movieDetail
        Glide.with(this).load(Constant.IMAGE_BASE_URL + Constant.IMAGE_W342 + movieDetail.backdrop_path).into(iv_detail_poster_path)
        ppBar.visibility= View.INVISIBLE
    }

}
