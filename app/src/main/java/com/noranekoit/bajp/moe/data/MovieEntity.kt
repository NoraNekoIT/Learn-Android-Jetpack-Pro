package com.noranekoit.bajp.moe.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity(
    val id: String,
    val title: String,
    val description: String,
    val dateAiring: String,
    val score: String,
    val imagePath: String
) : Parcelable