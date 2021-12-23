package com.noranekoit.bajp.moe.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.remote.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovies(): LiveData<List<MovieEntity>> = movieRepository.getAllMoviePopulars()

}