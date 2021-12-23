package com.noranekoit.bajp.moe.data.source.remote.network

import com.noranekoit.bajp.moe.BuildConfig
import com.noranekoit.bajp.moe.data.source.remote.response.CatalogueResponse
import com.noranekoit.bajp.moe.data.source.remote.response.movie.DetailMovieResponse
import com.noranekoit.bajp.moe.data.source.remote.response.movie.MovieResponse
import com.noranekoit.bajp.moe.data.source.remote.response.tvshow.DetailTvShowResponse
import com.noranekoit.bajp.moe.data.source.remote.response.tvshow.TvShowResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("movie/popular")
    fun getMoviePopular(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_KEY
    ): Call<CatalogueResponse<MovieResponse>>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_KEY
    ) : Call<DetailMovieResponse>

    @GET("tv/popular")
    fun getTvShowPopular(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_KEY
    ) : Call<CatalogueResponse<TvShowResponse>>

    @GET("tv/{tv_id}")
    fun getDetailTvShow(
        @Path("tv_id") tvShowId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_KEY
    ) : Call<DetailTvShowResponse>
}