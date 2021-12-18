package com.noranekoit.bajp.moe.ui.tvshow

import com.noranekoit.bajp.moe.data.MovieEntity

interface TvShowFragmentCallback {
    fun onShareClick(tvShows: MovieEntity)
}
