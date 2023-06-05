package com.aps.aly.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class BookX(
    val author_id: Int,
    val cover_image: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val isbn: String,
    val pages: Int,
    val releaseDate: String,
    val title: String
)