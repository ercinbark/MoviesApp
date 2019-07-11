package com.ercin.movies.ui.detail

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.graphics.Palette
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.ercin.movies.R
import com.ercin.movies.databinding.ActivityMovieDetailBinding
import com.ercin.movies.model.detail.MovieDetailResponse
import com.ercin.movies.util.Constant
import kotlinx.android.synthetic.main.activity_movie_detail.*


class MovieDetailActivity : AppCompatActivity(), MovieDetailNavigatorInterface {

    lateinit var viewModel: MovieDetailViewModel
    lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        viewModel = ViewModelProviders.of(this).get(MovieDetailViewModel::class.java)

        setSupportActionBar(anim_toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        viewModel.movieDetailId = intent.getIntExtra("movieID", 0)
        viewModel.setDetailNavigator(this)
        viewModel.requestMovieDetail()
        ppBar.visibility = View.VISIBLE

    }

    override fun showMovieDetail(movieDetail: MovieDetailResponse) {

        Log.e("movieTitle", movieDetail.titlee)
        binding.movieDetail = movieDetail
        Glide.with(this).load(Constant.IMAGE_BASE_URL + Constant.IMAGE_W342 + movieDetail.backdrop_path).into(iv_detail_poster_path)
        ppBar.visibility = View.INVISIBLE
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun setToolbar() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.no_poster)
        Palette.from(bitmap).generate { palette ->
            val color = palette?.getVibrantColor(R.attr.colorAccent)
            collapsing_toolbar.setContentScrimColor(color!!)

            window.statusBarColor = color
        }

    }

}
