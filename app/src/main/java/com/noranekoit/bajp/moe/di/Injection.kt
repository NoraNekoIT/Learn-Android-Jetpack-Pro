package com.noranekoit.bajp.moe.di
import com.noranekoit.bajp.moe.data.source.remote.MovieRepository
import com.noranekoit.bajp.moe.data.source.remote.RemoteDataSource

object Injection {
    fun provideMovieRepository(): MovieRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return MovieRepository.getInstance(remoteDataSource)
    }
}