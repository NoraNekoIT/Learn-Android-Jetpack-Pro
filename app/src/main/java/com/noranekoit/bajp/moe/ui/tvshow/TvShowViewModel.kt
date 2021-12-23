package com.noranekoit.bajp.moe.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.remote.MovieRepository

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getTvShows(): LiveData<List<MovieEntity>> = movieRepository.getAllTvShowPopulars()
}