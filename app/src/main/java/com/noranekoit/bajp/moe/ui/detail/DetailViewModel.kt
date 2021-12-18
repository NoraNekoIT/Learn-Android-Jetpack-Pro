package com.noranekoit.bajp.moe.ui.detail

import androidx.lifecycle.ViewModel
import com.noranekoit.bajp.moe.data.MovieEntity
import com.noranekoit.bajp.moe.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var id: String

    fun setSelectedMovie(id: String) {
        this.id = id
    }

    fun setSelectedTvShows(id: String) {
        this.id = id
    }

    fun getMovies(): MovieEntity {
        lateinit var id: MovieEntity
        val moviesEntities = DataDummy.generateDummyMovie()
        for (movieEntity in moviesEntities) {
            if (movieEntity.id == this.id) {
                id = movieEntity
            }
        }
        return id
    }

    fun getTvShows(): MovieEntity {
        lateinit var id: MovieEntity
        val tvShowsEntities = DataDummy.generateDummyTvShow()
        for (tvShowEntity in tvShowsEntities) {
            if (tvShowEntity.id == this.id) {
                id = tvShowEntity
            }
        }
        return id
    }


}