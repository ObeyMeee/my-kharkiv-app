package ua.com.andromeda.mykharkiv.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Category(
    id: Long,
    @StringRes nameResId: Int,
    @DrawableRes imageResId: Int,
    val recommendedPlaces: List<Place>
) : BaseModel(id, nameResId, imageResId)