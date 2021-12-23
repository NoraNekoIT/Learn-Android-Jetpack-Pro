package com.noranekoit.bajp.moe.utils

import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.remote.response.*
import com.noranekoit.bajp.moe.data.source.remote.response.movie.DetailMovieResponse
import com.noranekoit.bajp.moe.data.source.remote.response.movie.MovieResponse
import com.noranekoit.bajp.moe.data.source.remote.response.tvshow.DetailTvShowResponse
import com.noranekoit.bajp.moe.data.source.remote.response.tvshow.TvShowResponse
import kotlin.collections.ArrayList

object DataDummy {

    fun generateDummyMovie(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "1",
                "Spider-Man: No Way Home",
                "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                "2021-12-15",
                "8.6",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "2",
                "Spider-Man: No Way Home",
                "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man..",
                "12/17/2021",
                "88%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "3",
                "Red Notice",
                "An Interpol-issued Red Notice is a global alert to hunt and capture the world's most wanted. But when a daring heist brings together the FBI's top profiler and two rival criminals, there's no telling what will happen.",
                "11/05/2021",
                "68%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lAXONuqg41NwUMuzMiFvicDET9Y.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "4",
                "Encanto",
                "The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family with a unique gift from super strength to the power to heal—every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family's last hope.",
                "11/24/2021",
                "74%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "5",
                "Clifford the Big Red Dog",
                "As Emily struggles to fit in at home and at school, she discovers a small red puppy who is destined to become her best friend. When Clifford magically undergoes one heck of a growth spurt, becomes a gigantic dog and attracts the attention of a genetics company, Emily and her Uncle Casey have to fight the forces of greed as they go on the run across New York City. Along the way, Clifford affects the lives of everyone around him and teaches Emily and her uncle the true meaning of acceptance and unconditional love.",
                "11/10/2021",
                "75%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ygPTrycbMSFDc5zUpy4K5ZZtQSC.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "6",
                "Shang-Chin and the Legend of the Ten Rings",
                "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization.",
                "09/03/2021",
                "78%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "7",
                "The Last Duel",
                "King Charles VI declares that Knight Jean de Carrouges settle his dispute with his squire, Jacques Le Gris, by challenging him to a duel.",
                "10/15/2021",
                "76%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zjrJE0fpzPvX8saJXj8VNfcjBoU.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "8",
                "Ron's Gone Wrong",
                "In a world where walking, talking, digitally connected bots have become children's best friends, an 11-year-old finds that his robot buddy doesn't quite work the same as the others do.",
                "10/22/2021",
                "76%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gA9QxSravC2EVEkEKgyEmDrfL0e.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "9",
                "Chernobyl: Abyss",
                "The aftermath of a shocking explosion at the Chernobyl nuclear power station made hundreds of people sacrifice their lives to clean up the site of the catastrophe and to successfully prevent an even bigger disaster that could have turned a large part of the European continent into an uninhabitable exclusion zone. This is their story.",
                "04/15/2021",
                "63%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/kfQJQWFEoWRVBH8FUKnT0HX1yRS.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "10",
                "Diary of a Wimpy Kid",
                "Greg Heffley is a scrawny but ambitious kid with an active imagination and big plans to be rich and famous – he just has to survive middle school first.",
                "12/03/2021",
                "71%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/obg6lWuNaZkoSlwrVG4VVk4SmT.jpg"
            )
        )


        return movies
    }

    fun generateDummyTvShow(): List<MovieEntity> {

        val tvShows = ArrayList<MovieEntity>()

        tvShows.add(
            MovieEntity(
                "11",
                "Hawkeye",
                "Former Avenger Clint Barton has a seemingly simple mission: get back to his family for Christmas. Possible? Maybe with the help of Kate Bishop, a 22-year-old archer with dreams of becoming a superhero. The two are forced to work together when a presence from Barton’s past threatens to derail far more than the festive spirit.",
                "2021-11-24",
                "8.5",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pqzjCxPVc9TkVgGRWeAoMmyqkZV.jpg"
            )
        )
        tvShows.add(
            MovieEntity(
                "12",
                "The Wheel of Time",
                "Follow Moiraine, a member of the shadowy and influential all-female organization called the “Aes Sedai” as she embarks on a dangerous, world-spanning journey with five young men and women. Moiraine believes one of them might be the reincarnation of an incredibly powerful individual, whom prophecies say will either save humanity or destroy it.",
                "2021",
                "81%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/mpgDeLhl8HbhI03XLB7iKO6M6JE.jpg"
            )
        )
        tvShows.add(
            MovieEntity(
                "13",
                "Chucky",
                "After a vintage Chucky doll turns up at a suburban yard sale, an idyllic American town is thrown into chaos as a series of horrifying murders begin to expose the town’s hypocrisies and secrets. Meanwhile, the arrival of enemies — and allies — from Chucky’s past threatens to expose the truth behind the killings, as well as the demon doll’s untold origins.",
                "2021",
                "80%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iF8ai2QLNiHV4anwY1TuSGZXqfN.jpg"
            )
        )
        tvShows.add(
            MovieEntity(
                "14",
                "Wer weiB denn sowas?",
                "We don't have an overview translated in English. Help us expand our database by adding one.",
                "2015",
                "80%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/abKjah96esLWObidBcWmvKJv61E.jpg"
            )
        )
        tvShows.add(
            MovieEntity(
                "15",
                "Bluey",
                "Bluey is an inexhaustible six year-old Blue Heeler dog, who loves to play and turns everyday family life into extraordinary adventures, developing her imagination as well as her mental, physical and emotional resilience.",
                "2018",
                "71%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9p4pNoGcuyCfHcGWKNrTopqMWtq.jpg"
            )
        )
        tvShows.add(
            MovieEntity(
                "16",
                "Whele of Fortune",
                "This game show sees contestants solve word puzzles, similar to those used in Hangman, to win cash and prizes determined by spinning a giant carnival wheel.",
                "1983",
                "71%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2fvAIyVfFHQdhJ7OsJWuMlF7836.jpg"
            )
        )
        tvShows.add(
            MovieEntity(
                "17",
                "Natholdets julekalender",
                "We don't have an overview translated in English. Help us expand our database by adding one.",
                "2017",
                "0%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gFy3KtzEuipjQv9SNRvmSEA4N6D.jpg"
            )
        )
        tvShows.add(
            MovieEntity(
                "18",
                "People Puzzler",
                "Three lucky contestants put their pop culture knowledge to the test to complete iconic, People Puzzler crosswords. The player with the most points at the end of three rounds wins the game and goes on to play the \"Fast Puzzle Round\" for an enormous cash prize.",
                "2021",
                "68%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gELQSCY5KKIGQAmOHbcgcRGNlp5.jpg"
            )
        )
        tvShows.add(
            MovieEntity(
                "19",
                "Um Lugar ao Sol",
                "We don't have an overview translated in English. Help us expand our database by adding one.",
                "2021",
                "100%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8OYUkmD4fFtbG4MT4uYvnA632Cg.jpg"
            )
        )
        tvShows.add(
            MovieEntity(
                "20",
                "Nissene i bingen",
                "Norwegian Christmas calendar where 24 santas compete to be the last man standing.",
                "2021",
                "95%",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qhCED5zIguzY5UvZBs05AvLICVZ.jpg"
            )
        )

        return tvShows
    }

    fun generateRemoteDummyMovie(): ArrayList<MovieResponse> {
        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse(
                "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
                "en",
                "Suicide Squad",
                false,
                "Suicide Squad",
                listOf(
                    14,
                    28,
                    80
                ),
                "/e1mjopzAS2KNsvpbpahQ1a6SkSn.jpg",
                "/ndlQ2Cuc3cjTL7lTynw6I4boP4S.jpg",
                "2016-08-03",
                48.261451,
                5.91,
                297761,
                false,
                1466
            )
        )
        movies.add(
            MovieResponse(
                "The most dangerous former operative of the CIA is drawn out of hiding to uncover hidden truths about his past.",
                "en",
                "Jason Bourne",
                false,
                "Jason Bourne",
                listOf(
                    28,
                    53
                ),
                "/lFSSLTlFozwpaGlO31OoUeirBgQ.jpg",
                "/AoT2YrJUJlg5vKE3iMOLvHlTd3m.jpg",
                "2016-07-27",
                30.690177,
                5.25,
                324668,
                false,
                649
            )
        )
        return movies
    }

    fun generateRemoteDummyTvShow(): ArrayList<TvShowResponse> {
        val tvShow = ArrayList<TvShowResponse>()

        tvShow.add(
            TvShowResponse(
                "2010-06-08",
                "Based on the Pretty Little Liars series of young adult novels by Sara Shepard, the series follows the lives of four girls — Spencer, Hanna, Aria, and Emily — whose clique falls apart after the disappearance of their queen bee, Alison. One year later, they begin receiving messages from someone using the name \\\"A\\\" who threatens to expose their secrets — including long-hidden ones they thought only Alison knew.",
                "en",
                listOf(
                    18,
                    9648
                ),
                "/vC324sdfcS313vh9QXwijLIHPJp.jpg",
                listOf(
                    "US"
                ),
                "/rQGBjWNveVeF8f2PGRtS85w9o9r.jpg",
                "Pretty Little Liars",
                47.432451,
                5.04,
                "Pretty Little Liars",
                31917,
                133
            )
        )
        tvShow.add(
            TvShowResponse(
                "2015-05-27",
                "A contemporary and culturally resonant drama about a young programmer, Elliot, who suffers from a debilitating anti-social disorder and decides that he can only connect to people by hacking them. He wields his skills as a weapon to protect the people that he cares about. Elliot will find himself in the intersection between a cybersecurity firm he works for and the underworld organizations that are recruiting him to bring down corporate America.",
                "en",
                listOf(
                    80,
                    18
                ),
                "/esN3gWb1P091xExLddD2nh4zmi3.jpg",
                listOf(
                    "US"
                ),
                "/v8Y9yurHuI7MujWQMd8iL3Gy4B5.jpg",
                "Mr. Robot",
                37.882356,
                7.5,
                "Mr. Robot",
                62560,
                287,

                )
        )
        return tvShow
    }

    fun generateRemoteDummyDetailMovie(): DetailMovieResponse {
        return DetailMovieResponse(
            adult = false,
            backdropPath = "/sMRwI5trKI6qhxYcjPgGghmPBef.jpg",
            belongsToCollection = BelongsToCollection(
                id = 531242,
                name = "Suicide Squad Collection",
                posterPath = "/bdgaCpdDh0J0H7ZRpDP2NJ8zxJE.jpg",
                backdropPath = "/e0uUxFdhdGLcvy9eC7WlO2eLusr.jpg"
            ),
            budget = 175000000,
            genres = listOf(
                GenresItem(
                    id = 28,
                    name = "Action"
                ),
                GenresItem(
                    id = 12,
                    name = "Adventure"
                ),
                GenresItem(
                    id = 14,
                    name = "Fantasy"
                )
            ),
            homepage = "http://www.suicidesquad.com/",
            id = 297761,
            imdbId = "tt1386697",
            originalLanguage = "en",
            originalTitle = "Suicide Squad",
            overview = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
            popularity = 72.274,
            posterPath = "/xFw9RXKZDvevAGocgBK0zteto4U.jpg",
            productionCompanies = listOf(
                ProductionCompaniesItem(
                    id = 9993,
                    logoPath = "/2Tc1P3Ac8M479naPp1kYT3izLS5.png",
                    name = "DC Entertainment",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 444,
                    logoPath = "/42UPdZl6B2cFXgNUASR8hSt9mpS.png",
                    name = "Dune Entertainment",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 174,
                    logoPath = "/IuAlhI9eVC9Z8UQWOIDdWRKSEJ.png",
                    name = "Warner Bros. Pictures",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 507,
                    logoPath = "/z7H707qUWigbjHnJDMfj6QITEpb.png",
                    name = "Atlas Entertainment",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 429,
                    logoPath = "/2Tc1P3Ac8M479naPp1kYT3izLS5.png",
                    name = "DC Comics",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 128064,
                    logoPath = "/13F3Jf7EFAcREU0xzZqJnVnyGXu.png",
                    name = "DC Films",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 2723,
                    logoPath = null,
                    name = "Lin Pictures",
                    originCountry = "US"
                )


            ),
            productionCountries = listOf(
                ProductionCountriesItem(
                    iso31661 = "US",
                    name = "United States of America"
                )

            ),
            releaseDate = "2016-08-03",
            revenue = 746846894,
            runtime = 123,
            spokenLanguages = listOf(
                SpokenLanguagesItem(
                    englishName = "English",
                    iso6391 = "en",
                    name = "English"
                ),
                SpokenLanguagesItem(
                    englishName = "Japanese",
                    iso6391 = "ja",
                    name = "日本語"
                ),
                SpokenLanguagesItem(
                    englishName = "Spanish",
                    iso6391 = "es",
                    name = "Español"
                )
            ),

            status = "Released",
            tagline = "Worst Heroes Ever",
            title = "Suicide Squad",
            video = false,
            voteAverage = 5.9,
            voteCount = 18250
        )
    }

    fun generateRemoteDummyDetailTvShow(): DetailTvShowResponse {
        return DetailTvShowResponse(

            backdropPath = "/ypLoTftyF5EpGBxJas4PThIdiU4.jpg",
            createdBy = listOf(
                CreatedByItem(
                    id = 57062,
                    creditId = "5258a144760ee34661655204",
                    name = "I. Marlene King",
                    gender = 1,
                    profilePath = "/kODXeOzxJC8SINh7xeOlmzlHPNS.jpg"
                )
            ),

            episodeRunTime = listOf(
                41
            ),
            firstAirDate = "2010-06-08",
            genres = listOf(
                GenresItem(
                    id = 18,
                    name = "Drama"
                ),
                GenresItem(
                    id = 9648,
                    name = "Mystery"
                )
            ),
            homepage = "http://freeform.go.com/shows/pretty-little-liars",
            id = 31917,
            inProduction = false,
            languages = listOf(
                "en"
            ),
            lastAirDate = "2017-06-27",
            lastEpisodeToAir = LastEpisodeToAir(
                airDate = "2017-06-27",
                episodeNumber = 20,
                id = 1328760,
                name = "Til DeAth Do Us PArt",
                overview = "All is revealed as the ultimate endgame comes to light.",
                productionCode = "",
                seasonNumber = 7,
                stillPath = "/4IoXGT6ZwW1XgwWabyaIe2Yxdk4.jpg",
                voteAverage = 6.667,
                voteCount = 3
            ),
            name = "Pretty Little Liars",
            nextEpisodeToAir = null,
            networks = listOf(
                NetworksItem(
                    name = "ABC Family",
                    id = 75,
                    logoPath = "/p57JGkSUBdXbOtqkEKeTnfHn7kd.png",
                    originCountry = "US"
                ),
                NetworksItem(
                    name = "Freeform",
                    id = 1267,
                    logoPath = "/rsz16keQ0hiBWYpaKIFspsMwuqj.png",
                    originCountry = "US"
                )
            ),
            numberOfEpisodes = 161,
            numberOfSeasons = 7,
            originCountry = listOf(
                "US"
            ),
            originalLanguage = "en",
            originalName = "Pretty Little Liars",
            overview = "Based on the Pretty Little Liars series of young adult novels by Sara Shepard, the series follows the lives of four girls — Spencer, Hanna, Aria, and Emily — whose clique falls apart after the disappearance of their queen bee, Alison. One year later, they begin receiving messages from someone using the name \"A\" who threatens to expose their secrets — including long-hidden ones they thought only Alison knew.",
            popularity = 143.551,
            posterPath = "/aUPbHiLS3hCHKjtLsncFa9g0viV.jpg",
            productionCompanies = listOf(
                ProductionCompaniesItem(
                    id = 75339,
                    logoPath = null,
                    name = "Russian Hill Productions",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 29347,
                    logoPath = "/eJjnf008uDj3LZ3Fu8M8FKCkl6N.png",
                    name = "Warner Horizon Television",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 10067,
                    logoPath = "/p1kZoVNfkVvk7xyJZEposRxcfh8.png",
                    name = "Alloy Entertainment",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 75340,
                    logoPath = null,
                    name = "Long Lake Media",
                    originCountry = "US"
                )
            ),
            productionCountries = listOf(
                ProductionCountriesItem(
                    iso31661 = "US",
                    name = "United States of America"
                ),
            ),
            seasons = listOf(
                SeasonsItem(
                    airDate = "2012-08-28",
                    episodeCount = 11,
                    id = 43395,
                    name = "Specials",
                    overview = "",
                    posterPath = "/6Qt6NIlWxxuiNLsd9H9WxjWFmi8.jpg",
                    seasonNumber = 0
                ),
                SeasonsItem(
                    airDate = "2010-06-08",
                    episodeCount = 22,
                    id = 43392,
                    name = "Season 1",
                    overview = "",
                    posterPath = "/m4quKGjN9gt6SorPRqclVftPClW.jpg",
                    seasonNumber = 1
                ),
                SeasonsItem(
                    airDate = "2011-06-14",
                    episodeCount = 25,
                    id = 43393,
                    name = "Season 2",
                    overview = "Season two begins moments after the explosive season one finale and the girls are the talk of the town. Surprises and challenges will be in store for each, and \"A\" may succeed in her quest. Emily, Hanna, Spencer, and Aria are crumbling under the constant pressure of A's relentless texts and the knowledge that A inexplicably knows every little detail of their lives, including their thoughts, and is watching and anticipating the girls' every move. Spencer's family is falling apart. Aria and Ezra's relationship gets even more complicated, and Aria's brother Mike finds himself in trouble with the law, while their parents find themselves tested like never before.",
                    posterPath = "/4BikyFpJ9LnSxDXhuZF5QMFtKdl.jpg",
                    seasonNumber = 2
                ),
                SeasonsItem(
                    airDate = "2012-06-05",
                    episodeCount = 24,
                    id = 43394,
                    name = "Season 3",
                    overview = "",
                    posterPath = "/lSi1fFg21x2YMyAO49CmQTqK543.jpg",
                    seasonNumber = 3
                ),
                SeasonsItem(
                    airDate = "2013-06-11",
                    episodeCount = 24,
                    id = 43396,
                    name = "Season 4",
                    overview = "",
                    posterPath = "/x67TIFqCnFLLTVHi2vfxKFi1gPj.jpg",
                    seasonNumber = 4
                ),
                SeasonsItem(
                    airDate = "2014-06-10",
                    episodeCount = 26,
                    id = 61066,
                    name = "Season 5",
                    overview = "",
                    posterPath = "/rLUF1ta1XAks6lZSkq2dSEcMTfT.jpg",
                    seasonNumber = 5
                ),
                SeasonsItem(
                    airDate = "2015-06-02",
                    episodeCount = 20,
                    id = 66519,
                    name = "Season 6",
                    overview = "The girls may have gotten out of the Dollhouse but what happened to them during their time of captivity has lasting effects. With worried loved ones watching over them, the PLLs are home and trying to heal, with not much success. Even with suspected tormentor Andrew in custody, Aria, Emily, Hanna and Spencer fear they are far from safe. Meanwhile, Alison must deal with her past indiscretions and her notoriety around Rosewood.",
                    posterPath = "/qdvS6s5QRIx9lrgJLS29606vFmY.jpg",
                    seasonNumber = 6
                ),
                SeasonsItem(
                    airDate = "2016-06-21",
                    episodeCount = 20,
                    id = 76310,
                    name = "Season 7",
                    overview = "After Hanna's shocking abduction by \"Uber A\", the PLLs and company desperately race against the clock to save one of their own. The only way to do this is by handing over evidence of Charlotte's real murderer to \"Uber A\". In order to do so, the girls must decide what blatant lines they are willing to cross that they have never breached before; and once they cross that line, there is no turning back.",
                    posterPath = "/xWEYL5vBzzsSwlwRXJpIBmMbjwJ.jpg",
                    seasonNumber = 7
                ),
            ),
            spokenLanguages = listOf(
                SpokenLanguagesItem(
                    englishName = "English",
                    iso6391 = "en",
                    name = "English"
                )
            ),
            status =  "Ended",
        tagline =  "Time to bring your A game.",
        type =  "Scripted",
        voteAverage =  8.0,
        voteCount =  2013


        )
    }


}