package com.noranekoit.bajp.moe.ui.detail

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
class DetailViewModelTest {
    private lateinit var detailViewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.id

    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<MovieEntity>

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel(movieRepository)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        `when`(movieId?.toInt()?.let { movieRepository.getMovieDetail(it) }).thenReturn(movie)
        val movieEntity =
            movieId?.toInt()?.let { detailViewModel.getMovies(it).value } as MovieEntity
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.dateAiring, movieEntity.dateAiring)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.score, movieEntity.score)

        detailViewModel.getMovies(movieId.toInt()).observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<MovieEntity>()
        tvShow.value = dummyTvShow

        `when`(tvShowId?.toInt()?.let { movieRepository.getTvShowDetail(it) }).thenReturn(tvShow)
        val tvShowEntity =
            tvShowId?.toInt()?.let { detailViewModel.getTvShows(it).value } as MovieEntity
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.id, tvShowEntity.id)
        assertEquals(dummyTvShow.dateAiring, tvShowEntity.dateAiring)
        assertEquals(dummyTvShow.description, tvShowEntity.description)
        assertEquals(dummyTvShow.imagePath, tvShowEntity.imagePath)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.score, tvShowEntity.score)

        detailViewModel.getTvShows(tvShowId.toInt()).observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}