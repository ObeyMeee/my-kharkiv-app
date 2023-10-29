package ua.com.andromeda.mykharkiv.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.com.andromeda.mykharkiv.R
import ua.com.andromeda.mykharkiv.data.LocalPlacesDataProvider
import ua.com.andromeda.mykharkiv.data.model.Place
import ua.com.andromeda.mykharkiv.ui.utils.LinkText
import ua.com.andromeda.mykharkiv.ui.utils.LinkTextData

@Composable
fun PlaceDetailsScreen(
    place: Place,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(place.imageResId),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "location")
            Spacer(modifier = Modifier.width(8.dp))
            val uriHandler = LocalUriHandler.current
            LinkText(
                linkTextData = listOf(
                    LinkTextData(
                        text = stringResource(place.addressResId),
                        tag = "PlaceURL",
                        annotation = stringResource(place.googleMapLinkResId),
                        onClick = {
                            uriHandler.openUri(it.item)
                        }
                    )
                )
            )
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