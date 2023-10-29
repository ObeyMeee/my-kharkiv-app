package ua.com.andromeda.mykharkiv

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ua.com.andromeda.mykharkiv.data.LocalCategoriesDataProvider
import ua.com.andromeda.mykharkiv.ui.MyKharkivHomeScreen
import ua.com.andromeda.mykharkiv.ui.MyKharkivViewModel
import ua.com.andromeda.mykharkiv.ui.PlaceDetailsScreen
import ua.com.andromeda.mykharkiv.ui.PlacesListScreen

enum class MyKharkivScreen {
    Start,
    PlacesList,
    PlaceDetails
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyKharkivApp() {
    val viewModel: MyKharkivViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val navController = rememberNavController()
    val startScreen = MyKharkivScreen.Start.name

    Scaffold(
        topBar = {
            MyKharkivTopAppBar(
                title = uiState.title,
                onBackClicked = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = startScreen) {
            composable(route = startScreen) {
                MyKharkivHomeScreen(
                    categories = uiState.categories,
                    updateCurrentCategory = { category -> viewModel.updateCurrentCategory(category) },
                    navigateToPlacesList = { navController.navigate(MyKharkivScreen.PlacesList.name) },
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                )
                viewModel.updateTitle("Kharkiv \uD83C\uDDFA\uD83C\uDDE6😎💪")
            }
            composable(route = MyKharkivScreen.PlacesList.name) {
                PlacesListScreen(
                    places = LocalCategoriesDataProvider.findById(uiState.currentCategory.id).recommendedPlaces,
                    updateCurrentPlace = { place -> viewModel.updateCurrentPlace(place) },
                    navigateToPlaceDetails = { navController.navigate(MyKharkivScreen.PlaceDetails.name) },
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                )
                viewModel.updateTitle(stringResource(uiState.currentCategory.nameResId))
            }
            composable(route = MyKharkivScreen.PlaceDetails.name) {
                PlaceDetailsScreen(
                    place = uiState.currentPlace,
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .fillMaxSize()
                )
                viewModel.updateTitle(stringResource(uiState.currentPlace.nameResId))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyKharkivTopAppBar(
    title: String,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = title)
        },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = onBackClicked) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_button)
                )
            }
        }
    )
}
