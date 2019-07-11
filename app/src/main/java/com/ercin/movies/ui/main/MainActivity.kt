package com.ercin.movies.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ercin.movies.R
import com.ercin.movies.common.ViewPagerAdapte
import com.ercin.movies.ui.main.popular.PopularMoviesFragment
import com.ercin.movies.ui.main.toprated.TopRatedMoviesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()

    }

    fun setupUI(){
        setSupportActionBar(main_toolbar)
        setViewPager()
        main_tabs.setupWithViewPager(main_pager)

    }

    private fun setViewPager(){
        val adapter=ViewPagerAdapte(supportFragmentManager)
        adapter.apply {
            addFragment(PopularMoviesFragment(),"Popular")
            addFragment(TopRatedMoviesFragment(),"Top Rated")
        }
        main_pager.adapter=adapter
    }
}
