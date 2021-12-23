package com.noranekoit.bajp.moe.ui.tvshow

import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity

interface TvShowFragmentCallback {
    fun onShareClick(tvShows: MovieEntity)
}
