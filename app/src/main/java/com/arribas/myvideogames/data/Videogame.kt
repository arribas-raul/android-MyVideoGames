package com.arribas.myvideogames.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Videogame(
    val id: Number,
    @StringRes val name: Int,
    val type: String,
    @StringRes val description: Int,
    @StringRes val score: Int,
    @DrawableRes val img: Int
)
