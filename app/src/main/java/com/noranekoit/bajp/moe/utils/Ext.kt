package com.noranekoit.bajp.moe.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.noranekoit.bajp.moe.R


fun ImageView.loadImage(url: String?) {
    Glide.with(this.context)
        .load(url)
        .apply(
            RequestOptions.placeholderOf(R.drawable.ic_loading)
                .override(500, 500)
                .error(R.drawable.ic_error)
        )
        .centerCrop()
        .into(this)
}
