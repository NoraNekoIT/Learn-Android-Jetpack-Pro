package com.noranekoit.bajp.moe.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieEntities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    val id: String,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "dateAiring")
    val dateAiring: String?,

    @ColumnInfo(name = "score")
    val score: String?,

    @ColumnInfo(name = "imagePath")
    val imagePath: String?,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean =false
)