package com.noranekoit.bajp.moe.data.source.remote.network

import com.noranekoit.bajp.moe.BuildConfig
import com.noranekoit.bajp.moe.data.source.remote.response.CatalogueResponse
import com.noranekoit.bajp.moe.data.source.remote.response.movie.MovieResponse
import com.noranekoit.bajp.moe.data.source.remote.response.tvshow.TvShowResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("movie/popular")
    fun getMoviePopular(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_KEY
    ): Call<CatalogueResponse<MovieResponse>>

    @GET("tv/popular")
    fun getTvShowPopular(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_KEY
    ) : Call<CatalogueResponse<TvShowResponse>>

}