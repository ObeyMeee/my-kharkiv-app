package ua.com.andromeda.mykharkiv.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Place(
    val id: Long,
    @StringRes val nameResId: Int,
    @DrawableRes val imageResId: Int,
    @StringRes val addressResId: Int,
    @StringRes val details: Int,
    val categoryId: Long
)