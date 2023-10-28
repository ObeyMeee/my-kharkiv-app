package ua.com.andromeda.mykharkiv

import android.util.Log
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
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.Navigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ua.com.andromeda.mykharkiv.data.LocalCategoriesDataProvider
import ua.com.andromeda.mykharkiv.ui.MyKharkivHomeScreen
import ua.com.andromeda.mykharkiv.ui.MyKharkivViewModel
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

    // TODO: test
//    val currentScreen = MyKharkivScreen.valueOf(
//        navController.currentBackStackEntry?.destination?.route ?: MyKharkivScreen.Start.name
//    )

    val backStackEntry by navController.currentBackStackEntryAsState()
    val startScreen = MyKharkivScreen.Start.name
    val currentScreen = MyKharkivScreen.valueOf(
        backStackEntry?.destination?.route ?: startScreen
    )

    Scaffold(
        topBar = { MyKharkivTopAppBar(title = "Who knows", {}) }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = startScreen) {
            composable(route = startScreen) {
                MyKharkivHomeScreen(
                    categories = uiState.categories,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                )
            }
            composable(
                route = "${MyKharkivScreen.PlacesList.name}/{id}",
                arguments = listOf(navArgument("id") {
                    type = NavType.LongType
                })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getLong("id") ?: -1
                PlacesListScreen(
                    places = LocalCategoriesDataProvider.findById(id).recommendedPlaces,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                )
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
