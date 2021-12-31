package com.noranekoit.bajp.moe.utils

import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity
import com.noranekoit.bajp.moe.data.source.remote.response.movie.MovieResponse
import com.noranekoit.bajp.moe.data.source.remote.response.tvshow.TvShowResponse
import kotlin.collections.ArrayList

object DataDummy {

    fun generateDummyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                "1",
                "Spider-Man: No Way Home",
                "Peter Parker is unmasked and no longer able to separate his normal" +
                        " life from the high-stakes of being a super-hero. When he asks for help " +
                        "from Doctor Strange the stakes become even more dangerous, forcing him " +
                        "to discover what it truly means to be Spider-Man.",
                "2021-12-15",
                "8.4",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rjkmN1dniUHVYAtwu" +
                        "V3Tji7FsDO.jpg"
            )
        )
        return movies
    }

    fun generateDummyTvShow(): List<TvEntity> {
        val tvShows = ArrayList<TvEntity>()
        tvShows.add(
            TvEntity(
                "11",
                "Hawkeye",
                "Former Avenger Clint Barton has a seemingly simple mission: get back " +
                        "to his family for Christmas. Possible? Maybe with the help of Kate " +
                        "Bishop, a 22-year-old archer with dreams of becoming a superhero." +
                        " The two are forced to work together when a presence from Barton’s" +
                        " past threatens to derail far more than the festive spirit.",
                "2021-11-24",
                "8.5",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pqzjCxPVc9TkVg" +
                        "GRWeAoMmyqkZV.jpg"
            )
        )
        return tvShows
    }

    fun generateRemoteDummyMovie(): ArrayList<MovieResponse> {
        val movies = ArrayList<MovieResponse>()
        movies.add(
            MovieResponse(
                "From DC Comics comes the Suicide Squad, an antihero team of" +
                        " incarcerated supervillains who act as deniable assets for the" +
                        " United States government, undertaking high-risk black ops missions" +
                        " in exchange for commuted prison sentences.",
                "Suicide Squad",
                "/xFw9RXKZDvevAGocgBK0zteto4U.jpg",
                "2016-08-03",
                5.9,
                297761
            )
        )
        return movies
    }

    fun generateRemoteDummyTvShow(): ArrayList<TvShowResponse> {
        val tvShow = ArrayList<TvShowResponse>()
        tvShow.add(
            TvShowResponse(
                "2010-06-08",
                "Based on the Pretty Little Liars series of young adult novels by" +
                        " Sara Shepard, the series follows the lives of four girls — Spencer," +
                        " Hanna, Aria, and Emily — whose clique falls apart after the " +
                        "disappearance of their queen bee, Alison. One year later, they begin" +
                        " receiving messages from someone using the name \\\"A\\\" who threatens" +
                        " to expose their secrets — including long-hidden ones they thought only" +
                        " Alison knew.",
                "/aUPbHiLS3hCHKjtLsncFa9g0viV.jpg",
                8.0,
                "Pretty Little Liars",
                31917,
            )
        )
        return tvShow
    }

}