package ua.com.andromeda.mykharkiv.ui

import ua.com.andromeda.mykharkiv.data.LocalCategoriesDataProvider
import ua.com.andromeda.mykharkiv.data.LocalPlacesDataProvider
import ua.com.andromeda.mykharkiv.data.model.Category
import ua.com.andromeda.mykharkiv.data.model.Place

data class MyKharkivUiState(
    val categories: List<Category> = LocalCategoriesDataProvider.allCategories,
    val currentCategory: Category = LocalCategoriesDataProvider.allCategories.getOrElse(
        0
    ) { LocalCategoriesDataProvider.defaultCategory },
    val currentPlace: Place = LocalPlacesDataProvider.defaultPlace
)