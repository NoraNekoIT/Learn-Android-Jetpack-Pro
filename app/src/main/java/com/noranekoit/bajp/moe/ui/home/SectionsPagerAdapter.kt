package com.noranekoit.bajp.moe.ui.home


import androidx.fragment.app.Fragment

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

import com.noranekoit.bajp.moe.ui.movie.MovieFragment
import com.noranekoit.bajp.moe.ui.tvshow.TvShowFragment

class SectionsPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> MovieFragment()
            1 -> TvShowFragment()
            else -> Fragment()
        }
}