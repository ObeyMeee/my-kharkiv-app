package ua.com.andromeda.mykharkiv.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val id: Long,
    @StringRes val nameResId: Int,
    @DrawableRes val imageResId: Int,
    val recommendedPlaces: List<Place>
)