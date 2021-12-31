package com.noranekoit.bajp.moe.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.noranekoit.bajp.moe.vo.Resource
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity

interface MovieDataSource {
    fun getAllMoviePopulars(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllTvShowPopulars(): LiveData<Resource<PagedList<TvEntity>>>

    fun getMovieDetail(movieId: Int): LiveData<MovieEntity>

    fun getTvShowDetail(tvShowId: Int): LiveData<TvEntity>

    fun setFavoriteMovies(movie: MovieEntity, state: Boolean)

    fun getFavoritesMovies(): LiveData<PagedList<MovieEntity>>

    fun setFavoriteTvShow(tv: TvEntity, state: Boolean)

    fun getFavoritesTvShows(): LiveData<PagedList<TvEntity>>
}