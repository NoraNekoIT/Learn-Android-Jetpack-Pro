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

class MovieFragment : Fragment(), MovieFragmentCallback {
    private var _fragmentMovieBinding: FragmentMovieBinding? = null
    private val fragmentMovieBinding get() = _fragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        _fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)
        return fragmentMovieBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentMovieBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(
                this, factory
            )[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter(this)
            fragmentMovieBinding?.progressBar?.visibility = View.VISIBLE

            viewModel.getMovies().observe(viewLifecycleOwner, {
                fragmentMovieBinding?.progressBar?.visibility = View.GONE
                movieAdapter.setMovies(it)
            })

            fragmentMovieBinding?.let {
                with(it.rvMovie) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = movieAdapter
                }
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