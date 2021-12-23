package com.noranekoit.bajp.moe.data.source.remote.response

import androidx.lifecycle.LiveData
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity

interface MovieDataSource {
    fun getAllMoviePopulars(): LiveData<List<MovieEntity>>

    fun getAllTvShowPopulars(): LiveData<List<MovieEntity>>

    fun getMovieDetail(movieId: Int): LiveData<MovieEntity>

    fun getTvShowDetail(tvShowId: Int): LiveData<MovieEntity>

}