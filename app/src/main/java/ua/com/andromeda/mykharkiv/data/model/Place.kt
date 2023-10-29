package ua.com.andromeda.mykharkiv.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Place(
    id: Long,
    @StringRes nameResId: Int,
    @DrawableRes imageResId: Int,
    @StringRes val addressResId: Int,
    @StringRes val googleMapLinkResId: Int,
    @StringRes val details: Int,
    val categoryId: Long
) : BaseModel(id, nameResId, imageResId)