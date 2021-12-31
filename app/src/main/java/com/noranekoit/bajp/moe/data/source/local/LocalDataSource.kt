package com.noranekoit.bajp.moe.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity
import com.noranekoit.bajp.moe.data.source.local.room.MovieDao

class LocalDataSource constructor(private val mMovieDao: MovieDao){

    fun getMoviesPopulars(): DataSource.Factory<Int, MovieEntity> =mMovieDao.getMoviePopulars()

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> =mMovieDao.getFavoriteMovies()

    fun insertMovies(movies: List<MovieEntity>) = mMovieDao.insertMovies(movies)

    fun setFavoriteMovie(movie:MovieEntity, newState: Boolean){
        movie.favorite = newState
        mMovieDao.updateMovie(movie)
    }
    fun getMovieDetails(movieId: Int): LiveData<MovieEntity> =
        mMovieDao.getDetailMovieById(movieId)

    fun getTvShowDetails(tvId: Int): LiveData<TvEntity> =
        mMovieDao.getDetailTvShowById(tvId)

    fun getTvShowsPopulars(): DataSource.Factory<Int, TvEntity> =mMovieDao.getTvShowPopulars()

    fun getFavoriteTvShow(): DataSource.Factory<Int, TvEntity> =mMovieDao.getFavoriteTvShow()

    fun insertTvShows(tvShows: List<TvEntity>) = mMovieDao.insertTvShow(tvShows)

    fun setFavoriteTvShow(tvEntity: TvEntity, newState: Boolean){
        tvEntity.favorite = newState
        mMovieDao.updateTvShow(tvEntity)
    }

    companion object{
        private var INSTANCE : LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }

}