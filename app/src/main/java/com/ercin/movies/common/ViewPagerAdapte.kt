package com.ercin.movies.common

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class ViewPagerAdapte(fm:FragmentManager):FragmentStatePagerAdapter(fm) {

    private val fragmentList=ArrayList<Fragment>()
    private val fragmentTitleList=ArrayList<String>()

    override fun getItem(position: Int): Fragment=fragmentList[position]

    override fun getCount(): Int=fragmentList.size

    override fun getPageTitle(position: Int): CharSequence?=fragmentTitleList[position]

    fun addFragment(fragment:Fragment,title:String){
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }
}