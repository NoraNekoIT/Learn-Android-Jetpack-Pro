package com.noranekoit.bajp.moe.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.remote.MovieRepository
import com.noranekoit.bajp.moe.utils.DataDummy
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {
    private lateinit var tvShowViewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvShowRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        tvShowViewModel = TvShowViewModel(tvShowRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = DataDummy.generateDummyTvShow()
        val tvShow = MutableLiveData<List<MovieEntity>>()
        tvShow.value = dummyTvShow
        `when`(tvShowRepository.getAllTvShowPopulars()).thenReturn(tvShow)
        val tvShowEntities = tvShowViewModel.getTvShows().value
        verify(tvShowRepository).getAllTvShowPopulars()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        tvShowViewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}