package ua.com.andromeda.mykharkiv.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ua.com.andromeda.mykharkiv.R
import ua.com.andromeda.mykharkiv.data.model.BaseModel

@Composable
fun <T : BaseModel> ListItems(
    items: List<T>,
    activeItem: T,
    onCardClicked: (T) -> Unit,
    modifier: Modifier = Modifier,
) {
    val maxCardHeight = LocalConfiguration.current.screenHeightDp / 5
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_between_items)),
        userScrollEnabled = true
    ) {
        items(items = items) {
            ItemCard(
                item = it,
                isActive = activeItem.id == it.id,
                modifier = Modifier
                    .padding(horizontal = dimensionResource(R.dimen.padding_medium))
                    .heightIn(min = 150.dp, max = maxCardHeight.dp)
                    .clickable { onCardClicked(it) }
            )
        }
    }
}

@Composable
fun <T : BaseModel> ItemCard(
    item: T,
    isActive: Boolean,
    modifier: Modifier = Modifier
) {
    val cardColors = if (isActive) {
        CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    } else {
        CardDefaults.cardColors()
    }
    Card(
        modifier = modifier,
        colors = cardColors
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            val nameResId = item.nameResId
            Image(
                painter = painterResource(item.imageResId),
                contentDescription = stringResource(nameResId),
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = stringResource(nameResId),
                modifier = Modifier.weight(4f),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}