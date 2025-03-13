package com.example.globalpizzahuntgame.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        modifier = modifier
    ) {
        composable(route = MyPizzaScreen.Start.name)
        {
            PizzaHomeScreen(
                onStartClick = {
                    navController.navigate(MyPizzaScreen.First.name)
                    viewModel.updateCurrentScreen(MyPizzaScreen.First)
                },
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        composable(route = MyPizzaScreen.First.name)
        {
            ClueScreen(
                onNextClick = {
                    navController.navigate(MyPizzaScreen.Second.name)
                },
                onHintClick = {},
                onSubmitLocation = {},
                cluePhoto = R.drawable.elysian_fields_1846,
                clueText = "The first locally recorded game of baseball took place in Hoboken in 1846. Please visit the historic landmark of this former site. ",
                //location = null,
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        composable(route = MyPizzaScreen.Second.name) {

        }

        composable(route = MyPizzaScreen.Third.name) {

        }

        composable(route = MyPizzaScreen.Fourth.name) {

        }

        composable(route = MyPizzaScreen.Fifth.name) {

        }



}
}