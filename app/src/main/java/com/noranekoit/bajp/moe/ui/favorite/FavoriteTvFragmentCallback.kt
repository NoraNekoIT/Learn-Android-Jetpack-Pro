package com.noranekoit.bajp.moe.ui.favorite

import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity

interface FavoriteTvFragmentCallback {
    fun onShareClick(tvEntity: TvEntity)
}