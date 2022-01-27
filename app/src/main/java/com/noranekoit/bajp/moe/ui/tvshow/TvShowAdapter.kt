package com.noranekoit.bajp.moe.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.noranekoit.bajp.moe.BuildConfig
import com.noranekoit.bajp.moe.R
import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity
import com.noranekoit.bajp.moe.databinding.ItemsTvShowBinding
import com.noranekoit.bajp.moe.ui.detail.DetailActivity
import com.noranekoit.bajp.moe.utils.loadImage

class TvShowAdapter(private val callback: TvShowFragmentCallback) :
    PagedListAdapter<TvEntity, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsTvShowBinding =
            ItemsTvShowBinding.inflate(LayoutInflater.from(parent.context), parent,
                false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    inner class TvShowViewHolder(private val binding: ItemsTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvEntity) {
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
                tvShows.imagePath?.let {
                    imgPoster.loadImage("${BuildConfig.BASE_URL_IMAGE}${it}")
                }

            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvEntity>() {
            override fun areItemsTheSame(oldItem: TvEntity, newItem: TvEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvEntity, newItem: TvEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

}