package com.example.globalpizzahuntgame.ui


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.globalpizzahuntgame.MyPizzaScreen
import com.example.globalpizzahuntgame.R
import com.example.globalpizzahuntgame.ui.components.HintDialog


@Composable
fun PizzaApp(
    navController: NavHostController = rememberNavController(),
    viewModel: PizzaViewModel,
    timerViewModel: TimerViewModel,
    modifier: Modifier
) {
    val timerValue by timerViewModel.timer.collectAsState()

    if (viewModel.getAlertDialog()) {
        HintDialog(
            onDismissRequest = { viewModel.setAlertDialog(false) },
            onConfirmation = { viewModel.setAlertDialog(false) },
            dialogTitle = viewModel.getAlertTitle(),
            dialogText = viewModel.getAlertText(),
            icon = Icons.Default.Search
        )
    }


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
                    timerViewModel.startTimer()
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
                    timerViewModel.stopTimer()
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
                timerValue = timerValue,
                //location = null,
                modifier = Modifier
                    .fillMaxSize()
            )
        }

    }

}
