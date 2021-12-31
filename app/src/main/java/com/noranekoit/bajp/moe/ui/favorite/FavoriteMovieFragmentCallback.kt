package com.noranekoit.bajp.moe.ui.favorite

import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity

interface FavoriteMovieFragmentCallback {
    fun onShareClick(movieEntity: MovieEntity)
}