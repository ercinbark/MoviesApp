package com.ercin.movies.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.ercin.movies.R
import com.ercin.movies.base.BaseActivity
import com.ercin.movies.databinding.ActivityMovieDetailBinding
import com.ercin.movies.model.detail.MovieDetailResponse
import com.ercin.movies.util.Constant
import com.google.android.material.tabs.TabLayout
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
        Log.e("XXXX", "" + movieDetailId)
        viewModelMovieDetail.setDetailNavigator(this)
        viewModelMovieDetail.requestMovieDetail()


        tab_detail.addTab(tab_detail.newTab().setText("Overview"))
        tab_detail.addTab(tab_detail.newTab().setText("Review"))
        tab_detail.tabGravity = TabLayout.GRAVITY_FILL

        val tabsPagerAdapter =
            MovieDetailPagerAdapter(this, supportFragmentManager, tab_detail.tabCount)
        viewPager_detail.adapter = tabsPagerAdapter
        viewPager_detail.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_detail))
        tab_detail.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(tablayout: TabLayout.Tab?) {
                viewPager_detail.currentItem = tablayout!!.position
            }
        })



        viewModelMovieDetail.loading.observe(this, Observer<Boolean> {
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
            .into(iv_detail_back_drop)

        Glide.with(this)
            .load(Constant.IMAGE_BASE_URL + Constant.IMAGE_W342 + movieDetail.poster_path)
            .into(iv_detail_poster_path)

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()

    }
}
