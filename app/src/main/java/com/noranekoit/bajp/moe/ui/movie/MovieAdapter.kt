package com.noranekoit.bajp.moe.ui.movie


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.noranekoit.bajp.moe.BuildConfig
import com.noranekoit.bajp.moe.R
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.databinding.ItemsMovieBinding
import com.noranekoit.bajp.moe.ui.detail.DetailActivity
import com.noranekoit.bajp.moe.utils.loadImage


class MovieAdapter(private val callback: MovieFragmentCallback) :
    PagedListAdapter<MovieEntity, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsHomeBinding = ItemsMovieBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return MovieViewHolder(itemsHomeBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }

    }

    inner class MovieViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemDate.text =
                    itemView.resources.getString(R.string.deadline_date, movie.dateAiring)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movie.id)
                    itemView.context.startActivity(intent)
                }
                imgShareMovie.setOnClickListener { callback.onShareClick(movie) }
                movie.imagePath?.let {
                    imgPoster.loadImage("${BuildConfig.BASE_URL_IMAGE}${it}")
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

}