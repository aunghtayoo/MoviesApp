package com.example.moviesapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.moviesapp.delegates.GetMovieInfoDelegate
import com.example.moviesapp.fragments.NowShowingTabFragment

class MovieFragmentTVAdapter(fm: FragmentManager, private val delegate: GetMovieInfoDelegate) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return NowShowingTabFragment(delegate)
            1 -> return NowShowingTabFragment(delegate)
            2 -> return NowShowingTabFragment(delegate)
            else -> return NowShowingTabFragment(delegate)
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "Now Showing"
            1 -> return "Cinema"
            2 -> return "Coming Soon"
            else -> return ""
        }
    }
}