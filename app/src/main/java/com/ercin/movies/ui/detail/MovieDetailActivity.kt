package com.ercin.movies.ui.detail

import androidx.databinding.DataBindingUtil
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.palette.graphics.Palette
import android.util.Log
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.ercin.movies.R
import com.ercin.movies.base.BaseActivity
import com.ercin.movies.databinding.ActivityMovieDetailBinding
import com.ercin.movies.model.detail.MovieDetailResponse
import com.ercin.movies.util.Constant
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

        setSupportActionBar(anim_toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        movieDetailId = intent.getIntExtra("movieID", 0)
        viewModelMovieDetail.setDetailNavigator(this)
        viewModelMovieDetail.requestMovieDetail()

        viewModelMovieDetail.loading.observe(this, Observer {
            if (it)
                showFullScreenProgressDialog(false)
            else
                dismissFullScreenProgressDialog()
        })


    }

    override fun showMovieDetail(movieDetail: MovieDetailResponse) {
        Log.e("XXXX", movieDetail.title)
        binding.movieDetail = movieDetail
        Glide.with(this)
            .load(Constant.IMAGE_BASE_URL + Constant.IMAGE_W342 + movieDetail.backdrop_path)
            .placeholder(R.drawable.no_poster)
            .into(iv_detail_poster_path)
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
