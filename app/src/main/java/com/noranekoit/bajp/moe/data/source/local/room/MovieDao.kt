package com.noranekoit.bajp.moe.data.source.local.room
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movieEntities")
    fun getMoviePopulars(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieEntities WHERE favorite=1")
    fun getFavoriteMovies(): DataSource.Factory<Int,MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("SELECT * FROM movieEntities WHERE movieId= :movieId")
    fun getDetailMovieById(movieId: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM tvEntities")
    fun getTvShowPopulars(): DataSource.Factory<Int, TvEntity>

    @Query("SELECT * FROM tvEntities WHERE favorite=1")
    fun getFavoriteTvShow(): DataSource.Factory<Int,TvEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShows: List<TvEntity>)

    @Update
    fun updateTvShow(tvShow: TvEntity)

    @Query("SELECT * FROM tvEntities WHERE tvId= :tvId")
    fun getDetailTvShowById(tvId: Int): LiveData<TvEntity>
}