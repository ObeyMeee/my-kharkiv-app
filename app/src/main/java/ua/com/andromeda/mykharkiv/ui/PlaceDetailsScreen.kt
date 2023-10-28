package ua.com.andromeda.mykharkiv.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ua.com.andromeda.mykharkiv.R
import ua.com.andromeda.mykharkiv.data.LocalPlacesDataProvider
import ua.com.andromeda.mykharkiv.data.model.Place

@Composable
fun PlaceDetailsScreen(
    place: Place,
    modifier: Modifier = Modifier
) {
    Column {
        Image(painter = painterResource(place.imageResId), contentDescription = null)
        Row {
            Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "location")
            Text(text = stringResource(place.addressResId))
        }
        Text(text = stringResource(place.details))
    }
}

@Preview
@Composable
fun PlaceDetailsScreen() {
    PlaceDetailsScreen(
        place = LocalPlacesDataProvider.defaultPlace, modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxSize()
    )
}