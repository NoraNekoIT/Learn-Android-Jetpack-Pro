package com.noranekoit.bajp.moe.data.source.remote

import android.util.Log
import com.noranekoit.bajp.moe.data.source.remote.network.ApiConfig
import com.noranekoit.bajp.moe.data.source.remote.response.CatalogueResponse
import com.noranekoit.bajp.moe.data.source.remote.response.movie.DetailMovieResponse
import com.noranekoit.bajp.moe.data.source.remote.response.movie.MovieResponse
import com.noranekoit.bajp.moe.data.source.remote.response.tvshow.DetailTvShowResponse
import com.noranekoit.bajp.moe.data.source.remote.response.tvshow.TvShowResponse
import com.noranekoit.bajp.moe.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor() {
    fun getMoviePopular(
        callback: LoadMoviesPopularCallback
    ) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getMoviePopular()
            .enqueue(object : Callback<CatalogueResponse<MovieResponse>>{
                override fun onResponse(
                    call: Call<CatalogueResponse<MovieResponse>>,
                    response: Response<CatalogueResponse<MovieResponse>>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.results?.let { callback.onAllMoviesReceived(it) }
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<CatalogueResponse<MovieResponse>>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    callback.onAllMoviesReceived(emptyList())
                    EspressoIdlingResource.decrement()
                }

            })

    }

    fun getMovieDetail(movieId: Int, callback: LoadDetailMovieCallback){
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getDetailMovie(movieId)
            .enqueue(object :Callback<DetailMovieResponse>{
                override fun onResponse(
                    call: Call<DetailMovieResponse>,
                    response: Response<DetailMovieResponse>
                ) {
                    if (response.isSuccessful){
                        response.body()?.let { callback.onDetailMovieReceived(it) }
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                    Log.e("FailureMovieDetail", "${t.message}")

                    EspressoIdlingResource.decrement()
                }
            })
    }

    fun getTvShowPopular(callback: LoadPopularTvShowCallback){
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getTvShowPopular()
            .enqueue(object :Callback<CatalogueResponse<TvShowResponse>>{
                override fun onResponse(
                    call: Call<CatalogueResponse<TvShowResponse>>,
                    response: Response<CatalogueResponse<TvShowResponse>>
                ) {
                    if (response.isSuccessful){
                        response.body()?.results?.let {
                            callback.onAllTvShowsReceived(it)
                        }
                        EspressoIdlingResource.decrement()
                    }
                }

                override fun onFailure(
                    call: Call<CatalogueResponse<TvShowResponse>>,
                    t: Throwable
                ) {
                    Log.e("Failure", "${t.message}")
                    callback.onAllTvShowsReceived(emptyList())
                    EspressoIdlingResource.decrement()
                }
            })
    }

    fun getTvShowDetail(tvShowId: Int, callback: LoadDetailTvShowCallback){
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getDetailTvShow(tvShowId)
            .enqueue(object :Callback<DetailTvShowResponse>{
                override fun onResponse(
                    call: Call<DetailTvShowResponse>,
                    response: Response<DetailTvShowResponse>
                ) {
                    if (response.isSuccessful){
                        response.body()?.let { callback.onDetailTvShowReceived(it) }
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<DetailTvShowResponse>, t: Throwable) {
                    Log.e("Failure","${t.message}")
                    EspressoIdlingResource.decrement()
                }
            })
    }

    interface LoadMoviesPopularCallback {
        fun onAllMoviesReceived(movieResponse: List<MovieResponse?>)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieReceived(movieResponse: DetailMovieResponse)
    }

    interface LoadPopularTvShowCallback {
        fun onAllTvShowsReceived(tvShowResponse: List<TvShowResponse?>)
    }

    interface LoadDetailTvShowCallback {
        fun onDetailTvShowReceived(tvShowResponse: DetailTvShowResponse)
    }

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }
}



