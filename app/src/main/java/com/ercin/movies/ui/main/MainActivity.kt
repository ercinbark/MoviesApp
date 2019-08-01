package com.ercin.movies.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import android.view.MenuItem
import com.ercin.movies.R
import com.ercin.movies.common.ViewPagerAdapte
import com.ercin.movies.ui.main.movies.MoviesFragment
import com.ercin.movies.ui.main.news.NewsFragment
import com.ercin.movies.ui.main.popular.PopularMoviesFragment
import com.ercin.movies.ui.main.profile.ProfileFragment
import com.ercin.movies.ui.main.toprated.TopRatedMoviesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    val TAB_MOVIES = 0
    val TAB_NEWS = 1
    val TAB_PROFILE = 2
    lateinit var moviesFragment: MoviesFragment
    lateinit var newsFragment: NewsFragment
    lateinit var profileFragment: ProfileFragment
    var mainPagerAdapter: MainViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(main_toolbar)
        main_bottomNavigationView.setOnNavigationItemSelectedListener(this)
        setViewPager()

    }

    fun setViewPager() {
        mainPagerAdapter = MainViewPager(supportFragmentManager)
        vp_mainPager.adapter = mainPagerAdapter
        vp_mainPager.offscreenPageLimit = 3


        vp_mainPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        if (main_bottomNavigationView.selectedItemId != R.id.navigation_movie) {
                            main_bottomNavigationView.selectedItemId = R.id.navigation_movie
                            main_toolbar.title="Movie"
                        }
                    }
                    1 -> {
                        if (main_bottomNavigationView.selectedItemId != R.id.navigation_news) {
                            main_bottomNavigationView.selectedItemId = R.id.navigation_news
                            main_toolbar.title="News"
                        }
                    }
                    2 -> {
                        if (main_bottomNavigationView.selectedItemId != R.id.navigation_profile) {
                            main_bottomNavigationView.selectedItemId = R.id.navigation_profile
                            main_toolbar.title="Profile"
                        }
                    }
                }
            }
        })
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.navigation_movie -> {
                vp_mainPager.currentItem = TAB_MOVIES
                return true
            }
            R.id.navigation_news -> {
                vp_mainPager.currentItem = TAB_NEWS
                return true
            }
            R.id.navigation_profile -> {
                vp_mainPager.currentItem = TAB_PROFILE
                return true
            }
        }
        return false
    }

    inner class MainViewPager(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
        val TAB_ITEMS = 3
        override fun getItem(tab_position: Int): Fragment {
            return when (tab_position) {
                0 -> {
                    moviesFragment = MoviesFragment()
                    moviesFragment
                }
                1 -> {
                    newsFragment = NewsFragment()
                    newsFragment
                }
                else -> {
                    profileFragment = ProfileFragment()
                    profileFragment
                }
            }
        }

        override fun getCount(): Int {
            return TAB_ITEMS
        }

    }


    /*fun setupUI(){
        setSupportActionBar(main_toolbar)
        setViewPager()
        main_tabs.setupWithViewPager(main_pager)

    }

    /private fun setViewPager(){
        val adapter=ViewPagerAdapte(supportFragmentManager)
        adapter.apply {
            addFragment(PopularMoviesFragment(),"Popular")
            addFragment(TopRatedMoviesFragment(),"Top Rated")
        }
        main_pager.adapter=adapter
    }*/
}
