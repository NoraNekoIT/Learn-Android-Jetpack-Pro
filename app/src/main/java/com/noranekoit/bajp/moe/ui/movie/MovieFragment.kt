package com.noranekoit.bajp.moe.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.noranekoit.bajp.moe.R
import com.noranekoit.bajp.moe.data.MovieEntity

import com.noranekoit.bajp.moe.databinding.FragmentMovieBinding

class MovieFragment : Fragment(), MovieFragmentCallback {
    private var _fragmentMovieBinding: FragmentMovieBinding? = null
    private val fragmentMovieBinding get() = _fragmentMovieBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentMovieBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[MovieViewModel::class.java]
            val movies = viewModel.getMovies()
            val movieAdapter = MovieAdapter(this)
            movieAdapter.setMovies(movies)
            with(fragmentMovieBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
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