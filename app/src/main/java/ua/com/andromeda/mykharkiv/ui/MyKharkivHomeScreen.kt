package ua.com.andromeda.mykharkiv.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import ua.com.andromeda.mykharkiv.MyKharkivScreen
import ua.com.andromeda.mykharkiv.R
import ua.com.andromeda.mykharkiv.data.LocalCategoriesDataProvider
import ua.com.andromeda.mykharkiv.data.model.Category


@Composable
fun MyKharkivHomeScreen(
    categories: List<Category>,
    modifier: Modifier = Modifier,
) {
    ListItems(
        items = categories,
        navigateToScreen = MyKharkivScreen.PlacesList,
        modifier = modifier
    )
}


@Preview
@Composable
fun MyKharkivHomeScreenPreview() {
    MyKharkivHomeScreen(
        categories = LocalCategoriesDataProvider.allCategories,
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxSize()
    )
}