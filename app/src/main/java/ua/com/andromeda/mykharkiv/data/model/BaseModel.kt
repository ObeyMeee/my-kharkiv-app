package ua.com.andromeda.mykharkiv.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

abstract class BaseModel(
    val id: Long,
    @StringRes val nameResId: Int,
    @DrawableRes val imageResId: Int
)