package com.noranekoit.bajp.moe.ui.tvshow

import androidx.lifecycle.ViewModel
import com.noranekoit.bajp.moe.data.MovieEntity
import com.noranekoit.bajp.moe.utils.DataDummy

class TvShowViewModel : ViewModel() {

    fun getTvShows(): List<MovieEntity> = DataDummy.generateDummyTvShow()
}