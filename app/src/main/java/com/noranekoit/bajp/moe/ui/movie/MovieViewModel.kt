package com.noranekoit.bajp.moe.ui.movie

import androidx.lifecycle.ViewModel
import com.noranekoit.bajp.moe.data.MovieEntity
import com.noranekoit.bajp.moe.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovie()

}