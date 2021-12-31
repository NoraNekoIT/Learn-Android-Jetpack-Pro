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
import com.noranekoit.bajp.moe.data.source.local.entity.TvEntity
import com.noranekoit.bajp.moe.databinding.FragmentTvShowBinding
import com.noranekoit.bajp.moe.viewmodel.ViewModelFactory
import com.noranekoit.bajp.moe.vo.Status

class TvShowFragment : Fragment(), TvShowFragmentCallback {
    private var _fragmentTvShowBinding: FragmentTvShowBinding? = null
    private val fragmentTvShowBinding get() = _fragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {

        _fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container,
            false)
        return fragmentTvShowBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentTvShowBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(
                this,
                factory
            )[TvShowViewModel::class.java]

            val adapter = TvShowAdapter(this)

            viewModel.getTvShows().observe(viewLifecycleOwner, { tvShows ->
                if (tvShows != null) {
                    when (tvShows.status) {
                        Status.LOADING -> {
                            fragmentTvShowBinding?.progressBar?.visibility = View.VISIBLE
                            fragmentTvShowBinding?.error?.visibility = View.GONE
                        }
                        Status.SUCCESS -> {
                            fragmentTvShowBinding?.progressBar?.visibility = View.GONE
                            fragmentTvShowBinding?.error?.visibility = View.GONE
                            adapter.submitList(tvShows.data)

                        }
                        Status.ERROR -> {
                            fragmentTvShowBinding?.progressBar?.visibility = View.GONE
                            fragmentTvShowBinding?.error?.visibility = View.VISIBLE
                        }
                    }
                }

            })

            with(fragmentTvShowBinding?.rvTvShow) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = adapter
            }
        }
    }

    override fun onShareClick(tvShows: TvEntity) {
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
