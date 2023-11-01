package ua.com.andromeda.mykharkiv.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import ua.com.andromeda.mykharkiv.R
import ua.com.andromeda.mykharkiv.data.model.Place
import ua.com.andromeda.mykharkiv.utils.MyKharkivContentType

@Composable
fun PlacesListScreen(
    uiState: MyKharkivUiState,
    onPlaceClicked: (Place) -> Unit,
    modifier: Modifier = Modifier,
    contentType: MyKharkivContentType = MyKharkivContentType.LIST_ONLY,
) {
    val places = uiState.currentCategory.recommendedPlaces
    val currentPlace = uiState.currentPlace
    if (contentType == MyKharkivContentType.LIST_ONLY) {
        ListItems(
            items = places,
            activeItem = currentPlace,
            onCardClicked = onPlaceClicked,
            modifier = modifier
        )
    } else {
        PlacesListAndDetails(
            places = places,
            currentPlace = currentPlace,
            onPlaceClicked = onPlaceClicked,
            modifier = modifier
        )
    }
}

@Composable
fun PlacesListAndDetails(
    places: List<Place>,
    currentPlace: Place,
    onPlaceClicked: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        ListItems(
            items = places,
            activeItem = currentPlace,
            onCardClicked = onPlaceClicked,
            modifier = Modifier
                .weight(3f)
                .padding(horizontal = dimensionResource(R.dimen.padding_medium))
        )
        PlaceDetailsScreen(place = currentPlace, modifier = Modifier.weight(4f))
    }
}

@Preview
@Composable
fun PlacesListScreenPreview() {
    PlacesListScreen(
        uiState = MyKharkivUiState(),
        onPlaceClicked = { },
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
fun PlacesListScreenDarkPreview() {
    PlacesListScreen(
        uiState = MyKharkivUiState(),
        onPlaceClicked = { },
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxSize()
    )
}