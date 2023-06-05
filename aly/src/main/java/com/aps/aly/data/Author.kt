package com.aps.aly.data

import androidx.annotation.DrawableRes

data class Author(
    val id: Int,
    val name: String,
    val surname: String,
    @DrawableRes val image : Int
)