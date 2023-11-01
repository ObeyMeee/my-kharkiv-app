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
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ua.com.andromeda.mykharkiv.ui.MyKharkivHomeScreen
import ua.com.andromeda.mykharkiv.ui.MyKharkivUiState
import ua.com.andromeda.mykharkiv.ui.MyKharkivViewModel
import ua.com.andromeda.mykharkiv.ui.PlaceDetailsScreen
import ua.com.andromeda.mykharkiv.ui.PlacesListScreen
import ua.com.andromeda.mykharkiv.utils.MyKharkivContentType

enum class MyKharkivScreen {
    Start,
    PlacesList,
    PlaceDetails
}

@Composable
fun MyKharkivApp(windowWidthSizeClass: WindowWidthSizeClass) {
    val viewModel: MyKharkivViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val navController = rememberNavController()
    val startScreen = MyKharkivScreen.Start.name
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyKharkivScreen.valueOf(
        backStackEntry?.destination?.route ?: startScreen
    )
    val contentType = when (windowWidthSizeClass) {
        WindowWidthSizeClass.Expanded -> MyKharkivContentType.LIST_AND_DETAILS
        else -> MyKharkivContentType.LIST_ONLY
    }
    Scaffold(
        topBar = {
            MyKharkivTopAppBar(
                uiState = uiState,
                contentType = contentType,
                currentScreen = currentScreen,
                onBackClicked = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = startScreen) {
            composable(route = startScreen) {
                MyKharkivHomeScreen(
                    contentType = contentType,
                    uiState = uiState,
                    onCategoryClicked = { category ->
                        viewModel.updateCurrentCategory(category)
                        if (contentType == MyKharkivContentType.LIST_ONLY) {
                            navController.navigate(MyKharkivScreen.PlacesList.name)
                        }
                    },
                    onPlaceClicked = { place ->
                        viewModel.updateCurrentPlace(place)
                        navController.navigate(MyKharkivScreen.PlacesList.name)
                    },
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                )
            }
            composable(route = MyKharkivScreen.PlacesList.name) {
                PlacesListScreen(
                    contentType = contentType,
                    uiState = uiState,
                    onPlaceClicked = { place ->
                        viewModel.updateCurrentPlace(place)
                        if (contentType == MyKharkivContentType.LIST_ONLY) {
                            navController.navigate(MyKharkivScreen.PlaceDetails.name)
                        }
                    },
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                )
            }
            composable(route = MyKharkivScreen.PlaceDetails.name) {
                PlaceDetailsScreen(
                    place = uiState.currentPlace,
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .fillMaxSize()
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyKharkivTopAppBar(
    uiState: MyKharkivUiState,
    contentType: MyKharkivContentType,
    currentScreen: MyKharkivScreen,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(
                    when (currentScreen) {
                        MyKharkivScreen.Start ->
                            if (contentType == MyKharkivContentType.LIST_ONLY) R.string.app_title
                            else uiState.currentCategory.nameResId

                        MyKharkivScreen.PlacesList ->
                            if (contentType == MyKharkivContentType.LIST_ONLY) uiState.currentCategory.nameResId
                            else uiState.currentPlace.nameResId

                        MyKharkivScreen.PlaceDetails -> uiState.currentPlace.nameResId
                    }
                ),
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        },
        modifier = modifier,
        navigationIcon = {
            IconButton(
                onClick = onBackClicked,
                enabled = currentScreen != MyKharkivScreen.Start
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_button)
                )
            }
        }
    )
}
