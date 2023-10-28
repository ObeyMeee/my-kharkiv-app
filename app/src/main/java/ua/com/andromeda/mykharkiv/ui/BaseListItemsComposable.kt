package ua.com.andromeda.mykharkiv.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import ua.com.andromeda.mykharkiv.MyKharkivScreen
import ua.com.andromeda.mykharkiv.R
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ua.com.andromeda.mykharkiv.data.model.BaseModel

@Composable
fun <T: BaseModel> ListItems(
    items: List<T>,
    navigateToScreen: MyKharkivScreen,
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_between_items)),
        userScrollEnabled = true
    ) {
        items(items = items) {
            ItemCard(
                item = it,
                onClickCard = {
                    navController.navigate(
                        "${navigateToScreen.name}/${it.id}"
                    )
                },
                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium))
            )
        }
    }
}

@Composable
fun<T: BaseModel> ItemCard(
    item: T,
    onClickCard: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.clickable(onClick = onClickCard)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            val nameResId = item.nameResId
            Image(
                painter = painterResource(item.imageResId),
                contentDescription = stringResource(nameResId),
                modifier = Modifier.weight(3f)
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