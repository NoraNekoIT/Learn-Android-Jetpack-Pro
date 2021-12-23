package com.noranekoit.bajp.moe.data.source.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.noranekoit.bajp.moe.data.LiveDataTestUtil
import com.noranekoit.bajp.moe.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val movieResponse = DataDummy.generateRemoteDummyMovie()
    private val movieId = movieResponse[0].id.toString()
    private val movieDetail = DataDummy.generateRemoteDummyDetailMovie()
    private val tvShowResponse = DataDummy.generateRemoteDummyTvShow()
    private val tvId = tvShowResponse[0].id.toString()
    private val tvShowDetail = DataDummy.generateRemoteDummyDetailTvShow()

    @Test
    fun getAllMoviesPopular() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesPopularCallback)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).getMoviePopular(any())
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getAllMoviePopulars())
        verify(remote).getMoviePopular(any())

        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvShowPopular() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadPopularTvShowCallback)
                .onAllTvShowsReceived(tvShowResponse)
            null
        }.`when`(remote).getTvShowPopular(any())
        val tvEntities = LiveDataTestUtil.getValue(movieRepository.getAllTvShowPopulars())
        verify(remote).getTvShowPopular(any())

        assertNotNull(tvEntities)
        assertEquals(tvShowResponse.size.toLong(), tvEntities.size.toLong())
    }

    @Test
    fun getMovieDetail() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailMovieCallback).onDetailMovieReceived(
                movieDetail
            )
            null
        }.`when`(remote).getMovieDetail(eq(movieId.toInt()), any())

        val movieEntities =
            LiveDataTestUtil.getValue(movieRepository.getMovieDetail(movieId.toInt()))
        verify(remote).getMovieDetail(eq(movieId.toInt()), any())
        assertNotNull(movieEntities)
        assertEquals(movieDetail.id.toString(), movieEntities.id)
    }

    @Test
    fun getTvShowDetail() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailTvShowCallback).onDetailTvShowReceived(
                tvShowDetail
            )
            null
        }.`when`(remote).getTvShowDetail(eq(tvId.toInt()), any())

        val tvShowEntities =
            LiveDataTestUtil.getValue(movieRepository.getTvShowDetail(tvId.toInt()))
        verify(remote).getTvShowDetail(eq(tvId.toInt()), any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowDetail.id.toString(), tvShowEntities.id)
    }

}