package com.noranekoit.bajp.moe.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noranekoit.bajp.moe.data.source.remote.response.movie.DetailMovieResponse
import com.noranekoit.bajp.moe.data.source.remote.response.movie.MovieResponse
import com.noranekoit.bajp.moe.data.source.remote.response.tvshow.DetailTvShowResponse
import com.noranekoit.bajp.moe.data.source.remote.response.tvshow.TvShowResponse
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.remote.response.MovieDataSource

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

    override fun getAllMoviePopulars(): LiveData<List<MovieEntity>> {
        val listMoviePopularResult = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getMoviePopular(object :
            RemoteDataSource.LoadMoviesPopularCallback {
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse?>) {
                val movieList = ArrayList<MovieEntity>()
                if (movieResponse.isNotEmpty()) {
                    for (response in movieResponse) {
                        if (response !== null) {
                            val movie = MovieEntity(
                                response.id.toString(),
                                response.title,
                                response.overview,
                                response.releaseDate,
                                response.voteAverage.toString(),
                                response.posterPath
                            )
                            movieList.add(movie)
                        }
                    }
                    listMoviePopularResult.postValue(movieList)
                } else {
                    listMoviePopularResult.postValue(movieList)
                }
            }
        }
        )
        return listMoviePopularResult
    }

    override fun getAllTvShowPopulars(): LiveData<List<MovieEntity>> {
        val listTvShowResult = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getTvShowPopular(object : RemoteDataSource.LoadPopularTvShowCallback {
            override fun onAllTvShowsReceived(tvShowResponse: List<TvShowResponse?>) {
                val tvShowList = ArrayList<MovieEntity>()
                if (tvShowResponse.isNotEmpty()) {
                    for (response in tvShowResponse) {
                        if (response !== null) {
                            val tvShow = MovieEntity(
                                response.id.toString(),
                                response.name,
                                response.overview,
                                response.firstAirDate,
                                response.voteAverage.toString(),
                                response.posterPath
                            )
                            tvShowList.add(tvShow)
                        }
                    }
                    listTvShowResult.postValue(tvShowList)
                } else {
                    listTvShowResult.postValue(tvShowList)
                }
            }
        })
        return listTvShowResult
    }


    override fun getMovieDetail(movieId: Int): LiveData<MovieEntity> {
        val movieResult = MutableLiveData<MovieEntity>()
        remoteDataSource.getMovieDetail(
            movieId, object : RemoteDataSource.LoadDetailMovieCallback {
                override fun onDetailMovieReceived(movieResponse: DetailMovieResponse) {
                    val movie = MovieEntity(
                        movieResponse.id.toString(),
                        movieResponse.title,
                        movieResponse.overview,
                        movieResponse.releaseDate,
                        movieResponse.voteAverage.toString(),
                        movieResponse.posterPath
                    )

                    movieResult.postValue(movie)
                }
            }
        )
        return movieResult
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<MovieEntity> {
        val tvShowResult = MutableLiveData<MovieEntity>()

        remoteDataSource.getTvShowDetail(tvShowId, object
            : RemoteDataSource.LoadDetailTvShowCallback {
            override fun onDetailTvShowReceived(tvShowResponse: DetailTvShowResponse) {
                val tvShowDetail = MovieEntity(
                    tvShowResponse.id.toString(),
                    tvShowResponse.name,
                    tvShowResponse.overview,
                    tvShowResponse.firstAirDate,
                    tvShowResponse.voteAverage.toString(),
                    tvShowResponse.posterPath
                )
                tvShowResult.postValue(tvShowDetail)
            }
        }
        )
        return tvShowResult
    }

}