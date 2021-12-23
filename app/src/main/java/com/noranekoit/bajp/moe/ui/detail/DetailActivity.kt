package com.noranekoit.bajp.moe.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.noranekoit.bajp.moe.BuildConfig
import com.noranekoit.bajp.moe.R
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.databinding.ActivityDetailBinding
import com.noranekoit.bajp.moe.databinding.ContentDetailBinding
import com.noranekoit.bajp.moe.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailBinding.detailContent

        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(
            this, factory
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movie = extras.getString(EXTRA_MOVIE)
            val movieId = movie?.toInt()
            val tv = extras.getString(EXTRA_TV_SHOW)
            val tvId = tv?.toInt()
            if (movieId != null) {
                detailContentBinding.progressBar.visibility = View.VISIBLE
                viewModel.getMovies(movieId).observe(this, {
                    detailContentBinding.progressBar.visibility = View.GONE
                    populateMovies(it)
                })


            } else if (tvId != null) {
                detailContentBinding.progressBar.visibility = View.VISIBLE
                viewModel.getTvShows(tvId).observe(this, {
                    detailContentBinding.progressBar.visibility = View.GONE
                    populateMovies(it)
                })

            }

        }

    }

    private fun populateMovies(movieEntity: MovieEntity) {
        movieEntity.apply {
            detailContentBinding.apply {
                textTitle.text = movieEntity.title
                textDescription.text = movieEntity.description
                textDate.text = resources.getString(R.string.deadline_date, movieEntity.dateAiring)
                scoreUser.text = movieEntity.score
                Glide.with(this@DetailActivity)
                    .load("${BuildConfig.BASE_URL_IMAGE}${movieEntity.imagePath}")
                    .transform(RoundedCorners(20))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(detailContentBinding.imagePoster)
            }
        }

    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }
}