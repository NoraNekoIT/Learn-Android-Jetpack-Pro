package com.noranekoit.bajp.moe.ui.tvshow

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
import com.noranekoit.bajp.moe.databinding.FragmentTvShowBinding
import com.noranekoit.bajp.moe.viewmodel.ViewModelFactory

class TvShowFragment : Fragment(), TvShowFragmentCallback {
    private var _fragmentTvShowBinding: FragmentTvShowBinding? = null
    private val fragmentTvShowBinding get() = _fragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {

        _fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return fragmentTvShowBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentTvShowBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(
                this,factory
            )[TvShowViewModel::class.java]

            val adapter = TvShowAdapter(this@TvShowFragment)

            fragmentTvShowBinding?.progressBar?.visibility = View.VISIBLE
            viewModel.getTvShows().observe(viewLifecycleOwner, {
                fragmentTvShowBinding?.progressBar?.visibility =View.GONE
                adapter.setTvShows(it)
            })

            fragmentTvShowBinding?.let {
                with(it.rvTvShow) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    this.adapter = adapter
                }
            }
        }
    }

    override fun onShareClick(tvShows: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Share Application Now. You can See ")
                .setText(resources.getString(R.string.share_text, tvShows.title))
                .startChooser()
        }
    }
}
