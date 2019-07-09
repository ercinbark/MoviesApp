package com.ercin.moviesapp.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ercin.moviesapp.R
import com.ercin.moviesapp.common.ViewPagerAdapte
import com.ercin.moviesapp.ui.main.popular.PopularMoviesFragment
import com.ercin.moviesapp.ui.main.toprated.TopRatedMoviesFragment
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
