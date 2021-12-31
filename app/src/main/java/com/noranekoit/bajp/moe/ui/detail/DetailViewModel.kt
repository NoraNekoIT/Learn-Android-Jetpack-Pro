package com.noranekoit.bajp.moe.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.MovieRepository
import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(movieId: Int): LiveData<MovieEntity> = movieRepository.getMovieDetail(movieId)

    fun getTvShows(tvShowId: Int): LiveData<TvEntity> = movieRepository.getTvShowDetail(tvShowId)

    fun setFavoriteTvShow(tvEntity: TvEntity) {
        val newState = !tvEntity.favorite
        movieRepository.setFavoriteTvShow(tvEntity, newState)
    }
    fun setFavoriteMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.favorite
        movieRepository.setFavoriteMovies(movieEntity, newState)
    }

}