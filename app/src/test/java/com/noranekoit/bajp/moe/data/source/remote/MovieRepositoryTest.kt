package com.noranekoit.bajp.moe.data.source.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.noranekoit.bajp.moe.data.LiveDataTestUtil
import com.noranekoit.bajp.moe.data.PagedListUtil
import com.noranekoit.bajp.moe.data.source.local.LocalDataSource
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity
import com.noranekoit.bajp.moe.data.source.local.room.MovieDao
import com.noranekoit.bajp.moe.data.source.remote.response.RemoteDataSource
import com.noranekoit.bajp.moe.utils.AppExecutors
import com.noranekoit.bajp.moe.utils.DataDummy
import com.noranekoit.bajp.moe.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import java.util.concurrent.Executor

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val dao = mock(MovieDao::class.java)

    private val movieRepository = FakeMovieRepository(remote, local, appExecutors)

    private val movieDetail = DataDummy.generateDummyMovie()[0]

    private val movieResponse = DataDummy.generateRemoteDummyMovie()

    private val tvShowDetail = DataDummy.generateDummyTvShow()[0]

    private val tvShowResponse = DataDummy.generateRemoteDummyTvShow()

    @Mock
    private lateinit var  dataSourceFactoryMovie : DataSource.Factory<Int, MovieEntity>

    @Mock
    private lateinit var dataSourceFactoryTv : DataSource.Factory<Int, TvEntity>

    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
    }


    @Test
    fun getAllMoviesPopular() {
        `when`(local.getMoviesPopulars()).thenReturn(dataSourceFactoryMovie)
        movieRepository.getAllMoviePopulars()
        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getMoviesPopulars()

        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShowPopular() {
        `when`(local.getTvShowsPopulars()).thenReturn(dataSourceFactoryTv)
        movieRepository.getAllTvShowPopulars()
        val tvEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getTvShowsPopulars()

        assertNotNull(tvEntities)
        assertEquals(tvShowResponse.size.toLong(), tvEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = movieDetail
        `when`(local.getMovieDetails(movieDetail.id.toInt())).thenReturn(dummyMovie)

        val movieEntities =
            LiveDataTestUtil.getValue(movieRepository.getMovieDetail(movieDetail.id.toInt()))
        verify(local).getMovieDetails(movieDetail.id.toInt())
        assertNotNull(movieEntities)
        assertEquals(movieDetail.id, movieEntities.id)
    }

    @Test
    fun getTvShowDetail() {
        val dummyTv = MutableLiveData<TvEntity>()
        dummyTv.value = tvShowDetail
        `when`(local.getTvShowDetails(tvShowDetail.id.toInt())).thenReturn(dummyTv)

        val tvEntities =
            LiveDataTestUtil.getValue(movieRepository.getTvShowDetail(tvShowDetail.id.toInt()))
        verify(local).getTvShowDetails(tvShowDetail.id.toInt())
        assertNotNull(tvEntities)
        assertEquals(tvShowDetail.id, tvEntities.id)
    }

    @Test
    fun getFavoriteMovie() {
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactoryMovie)
        movieRepository.getFavoritesMovies()
        val movieEntity =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getFavoriteMovie()
        assertNotNull(movieEntity)
        assertEquals(movieResponse.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShows() {
        `when`(local.getFavoriteTvShow()).thenReturn(dataSourceFactoryTv)
        movieRepository.getFavoritesTvShows()
        val tvShowEntity =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getFavoriteTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(movieResponse.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

    @Test
    fun setMovieFavorite() {
        val localDataSource = LocalDataSource(dao)
        val dataDummyMovieFavorite = DataDummy.generateDummyMovie()[0]
        val expectedDummyMovieFavorite = dataDummyMovieFavorite.copy(favorite = true)
        val testExecutors = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())

        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when`(local).setFavoriteMovie(dataDummyMovieFavorite, true)
        movieRepository.setFavoriteMovies(dataDummyMovieFavorite, true)
        verify(local).setFavoriteMovie(dataDummyMovieFavorite, true)
        doNothing().`when`(dao).updateMovie(expectedDummyMovieFavorite)
        localDataSource.setFavoriteMovie(dataDummyMovieFavorite, true)
        verify(dao, times(1)).updateMovie(expectedDummyMovieFavorite)

    }

    @Test
    fun setTvFavorite() {
        val localDataSource = LocalDataSource(dao)
        val dataDummyTvFavorite = DataDummy.generateDummyTvShow()[0]
        val expectedDummyTvFavorite = dataDummyTvFavorite.copy(favorite = true)
        val testExecutors = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())

        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when`(local).setFavoriteTvShow(dataDummyTvFavorite, true)
        movieRepository.setFavoriteTvShow(dataDummyTvFavorite, true)
        verify(local).setFavoriteTvShow(dataDummyTvFavorite, true)
        doNothing().`when`(dao).updateTvShow(expectedDummyTvFavorite)
        localDataSource.setFavoriteTvShow(dataDummyTvFavorite, true)
        verify(dao, times(1)).updateTvShow(expectedDummyTvFavorite)
    }

    inner class TestExecutor : Executor {
        override fun execute(command: Runnable) {
            command.run()
        }
    }

}

