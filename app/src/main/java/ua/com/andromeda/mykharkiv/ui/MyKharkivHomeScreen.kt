package ua.com.andromeda.mykharkiv.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import ua.com.andromeda.mykharkiv.R
import ua.com.andromeda.mykharkiv.data.model.Category
import ua.com.andromeda.mykharkiv.data.model.Place
import ua.com.andromeda.mykharkiv.utils.MyKharkivContentType


@Composable
fun MyKharkivHomeScreen(
    uiState: MyKharkivUiState,
    onCategoryClicked: (category: Category) -> Unit,
    onPlaceClicked: (place: Place) -> Unit,
    modifier: Modifier = Modifier,
    contentType: MyKharkivContentType = MyKharkivContentType.LIST_ONLY,
) {
    if (contentType == MyKharkivContentType.LIST_ONLY) {
        ListItems(
            items = uiState.categories,
            activeItem = uiState.currentCategory,
            onCardClicked = onCategoryClicked,
            modifier = modifier
        )
    } else {
        AnimatedVisibility(visible = contentType == MyKharkivContentType.LIST_AND_DETAILS) {
            CategoriesListAndDetails(
                uiState = uiState,
                onCategoryClicked = onCategoryClicked,
                onPlaceClicked = onPlaceClicked,
                modifier = modifier
            )
        }
    }
}

@Composable
fun CategoriesListAndDetails(
    uiState: MyKharkivUiState,
    onCategoryClicked: (category: Category) -> Unit,
    onPlaceClicked: (place: Place) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        ListItems(
            items = uiState.categories,
            activeItem = uiState.currentCategory,
            onCardClicked = onCategoryClicked,
            modifier = Modifier
                .weight(2f)
                .padding(horizontal = dimensionResource(R.dimen.padding_medium))
        )
        ListItems(
            items = uiState.currentCategory.recommendedPlaces,
            activeItem = uiState.currentPlace,
            onCardClicked = onPlaceClicked,
            modifier = Modifier.weight(3f)
        )
    }
}

@Composable
fun MyKharkivHomeScreenPreview() {
    MyKharkivHomeScreen(
        uiState = MyKharkivUiState(),
        onCategoryClicked = {},
        onPlaceClicked = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxSize()
    )
}


@Preview(showBackground = true)
@Composable
fun MyKharkivHomeDarkScreenPreview() {
    MyKharkivHomeScreenPreview()
}

@Preview(showBackground = true, device = Devices.PHONE)
@Composable
fun MyKharkivHomeDarkScreenPhonePreview() {
    MyKharkivHomeScreenPreview()
}

@Preview(showBackground = true, device = Devices.TABLET)
@Composable
fun MyKharkivHomeDarkScreenTabletPreview() {
    MyKharkivHomeScreenPreview()
}