package com.noranekoit.bajp.moe.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.noranekoit.bajp.moe.BuildConfig
import com.noranekoit.bajp.moe.R
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity
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

        val factory = ViewModelFactory.getInstance(this)
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
                    setButtonFavorite(it,null)
                }
                )
            } else if (tvId != null) {
                detailContentBinding.progressBar.visibility = View.VISIBLE
                viewModel.getTvShows(tvId).observe(this, {
                    detailContentBinding.progressBar.visibility = View.GONE
                    populateTvShows(it)
                    setButtonFavorite(null,it)
                })
            }
        }

    }

    private fun setButtonFavorite(movie: MovieEntity?, tvShow: TvEntity?) {
        detailContentBinding.btnFavorite.setOnClickListener {
            setBookmark(movie, tvShow)
        }
    }

    private fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun setBookmark(movie: MovieEntity?, tvShow: TvEntity?) {
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        if (movie != null) {
            if (movie.favorite) {
                showToast("Deleted From Favorite Movie!")
            } else {
                showToast("Added To Favorite Movie!")
            }
            viewModel.setFavoriteMovie(movie)
        } else {
            if (tvShow != null) {
                if (tvShow.favorite) {
                    showToast("Deleted From Favorite Tv Show!")
                } else {
                    showToast("Added To Favorite Tv Show!")
                }
                viewModel.setFavoriteTvShow(tvShow)
            }
        }
    }

    private fun setBookmarkState(state: Boolean) {
        if (state){
            detailContentBinding.btnFavorite.setText(R.string.un_favorite)
        }else{
            detailContentBinding.btnFavorite.setText(R.string.favorite)
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
            setBookmarkState(favorite)
        }
    }

    private fun populateTvShows(tvEntity: TvEntity) {
        tvEntity.apply {
            detailContentBinding.apply {
                textTitle.text = tvEntity.title
                textDescription.text = tvEntity.description
                textDate.text = resources.getString(R.string.deadline_date, tvEntity.dateAiring)
                scoreUser.text = tvEntity.score
                Glide.with(this@DetailActivity)
                    .load("${BuildConfig.BASE_URL_IMAGE}${tvEntity.imagePath}")
                    .transform(RoundedCorners(20))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(detailContentBinding.imagePoster)
            }
            setBookmarkState(favorite)
        }
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }
}