package com.noranekoit.bajp.moe.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.remote.MovieRepository

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovies(movieId: Int): LiveData<MovieEntity> = movieRepository.getMovieDetail(movieId)

    fun getTvShows(tvShowId: Int): LiveData<MovieEntity> = movieRepository.getTvShowDetail(tvShowId)


}