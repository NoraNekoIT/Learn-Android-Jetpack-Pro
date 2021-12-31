package com.noranekoit.bajp.moe.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.noranekoit.bajp.moe.data.source.MovieRepository
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity

class FavoriteViewModel(private val movieRepository: MovieRepository): ViewModel() {
   fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> =
       movieRepository.getFavoritesMovies()

    fun getFavoriteTvShow(): LiveData<PagedList<TvEntity>> =
        movieRepository.getFavoritesTvShows()

}