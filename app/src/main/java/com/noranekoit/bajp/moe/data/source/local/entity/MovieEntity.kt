package com.noranekoit.bajp.moe.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity(
    val id: String?=null,
    val title: String?=null,
    val description: String?=null,
    val dateAiring: String?=null,
    val score: String?=null,
    val imagePath: String?=null
) : Parcelable