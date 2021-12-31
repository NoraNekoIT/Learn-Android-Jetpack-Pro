package com.noranekoit.bajp.moe.ui.tvshow

import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity

interface TvShowFragmentCallback {
    fun onShareClick(tvShows: TvEntity)
}
