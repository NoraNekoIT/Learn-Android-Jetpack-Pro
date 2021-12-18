package com.noranekoit.bajp.moe.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.noranekoit.bajp.moe.R
import com.noranekoit.bajp.moe.data.MovieEntity
import com.noranekoit.bajp.moe.databinding.ActivityDetailBinding
import com.noranekoit.bajp.moe.databinding.ContentDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailBinding.detailContent

        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            val tvId = extras.getString(EXTRA_TV_SHOW)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                populateMovies(viewModel.getMovies())
            } else if (tvId != null) {
                viewModel.setSelectedTvShows(tvId)
                populateMovies(viewModel.getTvShows())
            }

        }

    }

    private fun populateMovies(movieEntity: MovieEntity) {
        detailContentBinding.apply {
            textTitle.text = movieEntity.title
            textDate.text = resources.getString(R.string.deadline_date, movieEntity.dateAiring)
            textDescription.text = movieEntity.description
            scoreUser.text = movieEntity.score
        }

        resources.getString(R.string.deadline_date, movieEntity.dateAiring)

        Glide.with(this)
            .load(movieEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.imagePoster)
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }
}