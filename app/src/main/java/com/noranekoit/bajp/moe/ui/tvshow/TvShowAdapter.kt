package com.noranekoit.bajp.moe.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.noranekoit.bajp.moe.R
import com.noranekoit.bajp.moe.data.MovieEntity
import com.noranekoit.bajp.moe.databinding.ItemsTvShowBinding
import com.noranekoit.bajp.moe.ui.detail.DetailActivity

class TvShowAdapter(private val callback: TvShowFragmentCallback) :
    RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private val listTvShows = ArrayList<MovieEntity>()

    fun setTvShows(tvShows: List<MovieEntity>?) {
        if (tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsTvShowBinding =
            ItemsTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShows.size

    inner class TvShowViewHolder(private val binding: ItemsTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: MovieEntity) {
            with(binding) {
                tvItemTitle.text = tvShows.title
                tvItemDate.text =
                    itemView.resources.getString(R.string.deadline_date, tvShows.dateAiring)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TV_SHOW, tvShows.id)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(tvShows) }
                Glide.with(itemView.context)
                    .load(tvShows.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }
}