package com.noranekoit.bajp.moe.data.source.remote.response

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noranekoit.bajp.moe.data.source.remote.ApiResponse
import com.noranekoit.bajp.moe.data.source.remote.network.ApiConfig
import com.noranekoit.bajp.moe.data.source.remote.response.movie.MovieResponse
import com.noranekoit.bajp.moe.data.source.remote.response.tvshow.TvShowResponse
import com.noranekoit.bajp.moe.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor() {

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getMoviePopular(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovieResponse = MutableLiveData<ApiResponse<List<MovieResponse>>>()

        ApiConfig.getApiService().getMoviePopular()
            .enqueue(object : Callback<CatalogueResponse<MovieResponse>> {
                override fun onResponse(
                    call: Call<CatalogueResponse<MovieResponse>>,
                    response: Response<CatalogueResponse<MovieResponse>>
                ) {
                    if (response.isSuccessful) {
                        resultMovieResponse.postValue(ApiResponse.success(response.body()?.results as List<MovieResponse>))
                    }

                    EspressoIdlingResource.decrement()
                }


                override fun onFailure(call: Call<CatalogueResponse<MovieResponse>>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    resultMovieResponse.postValue(
                        ApiResponse.error(
                            t.message.toString(),
                            mutableListOf()
                        )
                    )

                    EspressoIdlingResource.decrement()
                }

            })
        return resultMovieResponse
    }

    fun getTvShowPopular(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultResponse = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        ApiConfig.getApiService().getTvShowPopular()
            .enqueue(object : Callback<CatalogueResponse<TvShowResponse>> {
                override fun onResponse(
                    call: Call<CatalogueResponse<TvShowResponse>>,
                    response: Response<CatalogueResponse<TvShowResponse>>
                ) {
                    if (response.isSuccessful) {
                        resultResponse.postValue(ApiResponse.success(response.body()?.results as List<TvShowResponse>))
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(
                    call: Call<CatalogueResponse<TvShowResponse>>,
                    t: Throwable
                ) {
                    Log.e("Failure", "${t.message}")
                    resultResponse.postValue(
                        ApiResponse.error(
                            t.message.toString(),
                            mutableListOf()
                        )
                    )
                    EspressoIdlingResource.decrement()
                }
            })
        return resultResponse
    }
}



