package com.noranekoit.bajp.moe.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.noranekoit.bajp.moe.R
import com.noranekoit.bajp.moe.data.source.local.entity.MovieEntity
import com.noranekoit.bajp.moe.databinding.FragmentMovieBinding
import com.noranekoit.bajp.moe.viewmodel.ViewModelFactory
import com.noranekoit.bajp.moe.vo.Status

class MovieFragment : Fragment(), MovieFragmentCallback {
    private var _fragmentMovieBinding: FragmentMovieBinding? = null
    private val fragmentMovieBinding get() = _fragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        _fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container,
            false)
        return fragmentMovieBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentMovieBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter(this)
            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> {
                            fragmentMovieBinding?.progressBar?.visibility = View.VISIBLE
                            fragmentMovieBinding?.error?.visibility = View.GONE
                        }
                        Status.SUCCESS -> {
                            fragmentMovieBinding?.error?.visibility = View.GONE
                            fragmentMovieBinding?.progressBar?.visibility = View.GONE
                            movieAdapter.submitList(movies.data)

                        }
                        Status.ERROR -> {
                            fragmentMovieBinding?.progressBar?.visibility = View.GONE
                            fragmentMovieBinding?.error?.visibility = View.VISIBLE
                        }
                    }
                }

            })
            with(fragmentMovieBinding?.rvMovie) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = movieAdapter
            }
        }
    }

    override fun onShareClick(movies: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Share Application Now. You can see ")
                .setText(resources.getString(R.string.share_text, movies.title))
                .startChooser()
        }
    }


}