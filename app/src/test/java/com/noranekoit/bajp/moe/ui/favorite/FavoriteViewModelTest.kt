package com.noranekoit.bajp.moe.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.noranekoit.bajp.moe.data.source.MovieRepository
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {
    private lateinit var favoriteViewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieObserver: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tvObserver: Observer<PagedList<TvEntity>>

    @Mock
    private lateinit var tvPagedList: PagedList<TvEntity>

    @Before
    fun setUp() {
        favoriteViewModel = FavoriteViewModel(movieRepository)
    }

    @Test
    fun `get favorite Movie`() {
        val dummyMovie = moviePagedList
        `when`(dummyMovie.size).thenReturn(4)
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dummyMovie
        `when`(movieRepository.getFavoritesMovies()).thenReturn(movie)
        val movieEntity = favoriteViewModel.getFavoriteMovie().value
        verify(movieRepository).getFavoritesMovies()
        Assert.assertNotNull(movieEntity)
        Assert.assertEquals(4, movieEntity?.size)
        favoriteViewModel.getFavoriteMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)

    }

    @Test
    fun `get favorite Tv Show`() {
        val dummyTv = tvPagedList
        `when`(dummyTv.size).thenReturn(4)
        val tv = MutableLiveData<PagedList<TvEntity>>()
        tv.value = dummyTv
        `when`(movieRepository.getFavoritesTvShows()).thenReturn(tv)
        val tvEntity = favoriteViewModel.getFavoriteTvShow().value
        verify(movieRepository).getFavoritesTvShows()
        Assert.assertNotNull(tvEntity)
        Assert.assertEquals(4, tvEntity?.size)
        favoriteViewModel.getFavoriteTvShow().observeForever(tvObserver)
        verify(tvObserver).onChanged(dummyTv)

    }

}