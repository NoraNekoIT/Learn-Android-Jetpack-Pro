package com.noranekoit.bajp.moe.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*

import com.noranekoit.bajp.moe.R
import com.noranekoit.bajp.moe.utils.DataDummy
import com.noranekoit.bajp.moe.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class HomeActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }


    @Test
    fun test1LoadMovies() {
        onView(withId(R.id.appBarLayout)).perform(swipeUp())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>
                (20)
        )
    }

    @Test
    fun test2LoadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        onView(withId(R.id.score_user)).check(matches(isDisplayed()))
        onView(withId(R.id.score_user)).check(matches(withText(dummyMovie[0].score)))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(withText(dummyMovie[0].description)))
        onView(withId(R.id.text_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_date)).check(
            matches(withText("Aired Date ${dummyMovie[0].dateAiring}"))
        )
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))

        pressBack()
    }


    @Test
    fun test3LoadTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.appBarLayout)).perform(swipeUp())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size)
        )

    }

    @Test
    fun test4LoadDetailTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        onView(withId(R.id.score_user)).check(matches(isDisplayed()))
        onView(withId(R.id.score_user)).check(matches(withText(dummyTvShow[0].score)))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(withText(dummyTvShow[0].description)))
        onView(withId(R.id.text_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_date)).check(
            matches(withText("Aired Date ${dummyTvShow[0].dateAiring}"))
        )
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))

        pressBack()

    }

    @Test
    fun test5GetEmptyFavorite() {
        onView(withText("FAVORITE")).perform(click())
        onView(withId(R.id.appBarLayout)).perform(swipeUp())
        onView(withId(R.id.text_empty_movie_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.text_empty_tv_fav)).check(matches(isDisplayed()))
    }

    @Test
    fun test6SetFavoriteMovie() {
        onView(withText("MOVIE")).perform(click())
        onView(withId(R.id.appBarLayout)).perform(swipeUp())
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
        pressBack()

        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click())
        )
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
        pressBack()
    }

    @Test
    fun test7SetFavoriteTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.appBarLayout)).perform(swipeUp())
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
        pressBack()

        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click())
        )
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
        pressBack()
    }

    @Test
    fun test8deleteFavoriteMovie() {
        onView(withText("FAVORITE")).perform(click())
        onView(withId(R.id.appBarLayout)).perform(swipeUp())
        onView(withId(R.id.rv_movie_favorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
        pressBack()

    }

    @Test
    fun test9deleteFavoriteTvShow() {
        onView(withText("FAVORITE")).perform(click())
        onView(withId(R.id.appBarLayout)).perform(swipeUp())
        onView(withId(R.id.rv_tv_favorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        onView(withId(R.id.btn_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
        pressBack()

    }
}