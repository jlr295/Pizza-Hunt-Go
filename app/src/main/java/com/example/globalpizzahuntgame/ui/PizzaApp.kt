package com.example.globalpizzahuntgame.ui


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
    modifier: Modifier
) {
    if (viewModel.getAlertDialog()) {
      viewModel.DisplayHint (
          onConfirmation = { viewModel.setAlertDialog(false) },
          onDismissRequest ={ viewModel.setAlertDialog(false) }
        ) }

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
                onCancel = {
                    navController.navigate(MyPizzaScreen.Start.name)
                },
                onHintClick = {
                    viewModel.setAlertDialog(bool = true)
                    viewModel.setAlertText(
                        currHintTitle = R.string.hint,
                        currHintText = R.string.elysian_fields_hint
                    )
                              },
                onFoundIt = {},
                cluePhoto = R.drawable.elysian_fields_1846,
                clueText = stringResource(R.string.Elysian_Fields_Clue),
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