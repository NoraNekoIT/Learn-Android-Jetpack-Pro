package com.noranekoit.bajp.moe.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.noranekoit.bajp.moe.R
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity
import com.noranekoit.bajp.moe.databinding.FragmentFavoriteBinding
import com.noranekoit.bajp.moe.viewmodel.ViewModelFactory

class FavoriteFragment : Fragment(), FavoriteMovieFragmentCallback, FavoriteTvFragmentCallback {
    private var _fragmentFavoriteBinding: FragmentFavoriteBinding? = null
    private val binding get() = _fragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavoriteBinding = FragmentFavoriteBinding.inflate(inflater, container,
            false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
            val movieAdapter = FavoriteMovieAdapter(this)
            val tvAdapter = FavoriteTvShowAdapter(this)
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { movies ->
                binding?.progressBar?.visibility = View.GONE
                movieAdapter.submitList(movies)
                if (movies.size == 0) binding?.textEmptyMovieFav?.visibility = View.VISIBLE
                else binding?.textEmptyMovieFav?.visibility = View.GONE

            })
            binding?.rvMovieFavorite?.apply {
                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,
                    false)
                setHasFixedSize(true)
                adapter = movieAdapter
            }

            viewModel.getFavoriteTvShow().observe(viewLifecycleOwner, { tvShows ->
                tvAdapter.submitList(tvShows)
                if (tvShows.size == 0) binding?.textEmptyTvFav?.visibility = View.VISIBLE
                else binding?.textEmptyTvFav?.visibility = View.GONE


            })
            binding?.rvTvFavorite?.apply {
                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,
                    false)
                setHasFixedSize(true)
                adapter = tvAdapter
            }

        }
    }


    override fun onShareClick(movieEntity: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Share Application Now. You can see ")
                .setText(resources.getString(R.string.share_text, movieEntity.title))
                .startChooser()
        }
    }

    override fun onShareClick(tvEntity: TvEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Share Application Now. You can see ")
                .setText(resources.getString(R.string.share_text, tvEntity.title))
                .startChooser()
        }
    }
}