package ua.com.andromeda.mykharkiv.data

import ua.com.andromeda.mykharkiv.R
import ua.com.andromeda.mykharkiv.data.LocalPlacesDataProvider.findAllByCategoryId
import ua.com.andromeda.mykharkiv.data.model.Category

object LocalCategoriesDataProvider {
    val defaultCategory = Category(-1, -1, -1, listOf())

    val allCategories = listOf(
        Category(
            1,
            R.string.category_1_name,
            R.drawable.coffee_shops,
            findAllByCategoryId(1)
        ),
        Category(
            2,
            R.string.category_2_name,
            R.drawable.restaurants,
            findAllByCategoryId(2)
        ),
        Category(
            3,
            R.string.category_3_name,
            R.drawable.parks,
            findAllByCategoryId(3)
        ),
        Category(
            4,
            R.string.category_4_name,
            R.drawable.shopping_centers,
            findAllByCategoryId(4)
        )
    )
}