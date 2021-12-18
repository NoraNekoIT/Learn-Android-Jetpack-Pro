package com.noranekoit.bajp.moe.ui.detail

import com.noranekoit.bajp.moe.utils.DataDummy
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class DetailViewModelTest {
    private lateinit var detailViewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.id

    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvShow.id

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel()
        detailViewModel.setSelectedMovie(movieId)
        detailViewModel.setSelectedTvShows(tvShowId)
    }

    @Test
    fun getMovie() {
        detailViewModel.setSelectedMovie(dummyMovie.id)
        val movieEntity = detailViewModel.getMovies()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.dateAiring, movieEntity.dateAiring)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.score, movieEntity.score)
    }

    @Test
    fun getTvShow() {
        detailViewModel.setSelectedTvShows(dummyTvShow.id)
        val tvShowEntity = detailViewModel.getTvShows()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.id, tvShowEntity.id)
        assertEquals(dummyTvShow.dateAiring, tvShowEntity.dateAiring)
        assertEquals(dummyTvShow.description, tvShowEntity.description)
        assertEquals(dummyTvShow.imagePath, tvShowEntity.imagePath)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.score, tvShowEntity.score)
    }
}