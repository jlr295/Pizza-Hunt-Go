package com.example.globalpizzahuntgame.ui


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.globalpizzahuntgame.MyPizzaScreen
import com.example.globalpizzahuntgame.R


@Composable
fun PizzaApp(
    navController: NavHostController = rememberNavController(),
    viewModel: PizzaViewModel,
    pizzaUiState: PizzaUiState,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MyPizzaScreen.Start.name,
        modifier = Modifier
            .padding(
                dimensionResource(R.dimen.padding_medium)
            )
    ) {
        composable(route = MyPizzaScreen.Start.name)
        {
            PizzaHomeScreen(
                onStartClick = { },
                modifier = Modifier
                    .fillMaxSize()
            )
        }


    }
}