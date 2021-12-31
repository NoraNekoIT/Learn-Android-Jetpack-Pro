package com.noranekoit.bajp.moe.di
import android.content.Context
import com.noranekoit.bajp.moe.data.source.MovieRepository
import com.noranekoit.bajp.moe.data.source.local.LocalDataSource
import com.noranekoit.bajp.moe.data.source.local.room.MovieDatabase
import com.noranekoit.bajp.moe.data.source.remote.response.RemoteDataSource
import com.noranekoit.bajp.moe.utils.AppExecutors
object Injection {
    fun provideMovieRepository(context: Context): MovieRepository {
        val database = MovieDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()
        return MovieRepository.getInstance(remoteDataSource,localDataSource,appExecutors)
    }
}