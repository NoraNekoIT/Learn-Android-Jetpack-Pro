package com.noranekoit.bajp.moe.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.noranekoit.bajp.moe.data.source.MovieRepository
import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity
import com.noranekoit.bajp.moe.vo.Resource

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getTvShows(): LiveData<Resource<PagedList<TvEntity>>> = movieRepository.getAllTvShowPopulars()
}