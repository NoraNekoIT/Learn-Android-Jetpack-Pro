package com.noranekoit.bajp.moe.ui.movie

import com.noranekoit.bajp.moe.data.MovieEntity

interface MovieFragmentCallback {
    fun onShareClick(movies: MovieEntity)
}