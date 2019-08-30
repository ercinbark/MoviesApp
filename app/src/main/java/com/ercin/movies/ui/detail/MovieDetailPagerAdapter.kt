package com.ercin.movies.ui.detail

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ercin.movies.ui.detail.tabs.MovieOverviewFragment
import com.ercin.movies.ui.detail.tabs.MovieReviewFragment

class MovieDetailPagerAdapter(
    val myContext: Context,
    fragmentManager: FragmentManager,
    internal var tabCount: Int
) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return MovieOverviewFragment()
            }
            1 -> {
                return MovieReviewFragment()
            }
            else -> return MovieOverviewFragment()
        }

    }

    override fun getCount(): Int {
        return tabCount
    }
}