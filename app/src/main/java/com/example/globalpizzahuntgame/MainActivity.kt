package com.example.globalpizzahuntgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.globalpizzahuntgame.ui.PizzaApp
import com.example.globalpizzahuntgame.ui.PizzaViewModel
import com.example.globalpizzahuntgame.ui.TimerViewModel
import com.example.globalpizzahuntgame.ui.components.PizzaAppBar
import com.example.globalpizzahuntgame.ui.theme.GlobalPizzaHuntGameTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<PizzaViewModel>()
    val timerViewModel: TimerViewModel by viewModels()
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GlobalPizzaHuntGameTheme(
                dynamicColor = false,
            ) {
                val layoutDirection = LocalLayoutDirection.current
                val windowSize = calculateWindowSizeClass(this)
                val viewModel: PizzaViewModel = viewModel
                val pizzaUiState = viewModel.uiState.collectAsState().value
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentScreen = MyPizzaScreen.valueOf(
                    backStackEntry?.destination?.route ?: MyPizzaScreen.Start.name)

                Scaffold(
                    topBar = {
                        PizzaAppBar(
                            currentScreen = currentScreen,
                            canNavigateBack = navController.previousBackStackEntry != null,
                            navigateUp = { navController.navigateUp() },
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    },
                    containerColor = MaterialTheme.colorScheme.surface,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            start = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateStartPadding(layoutDirection),
                            end = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateEndPadding(layoutDirection)
                        )
                ) { innerPadding ->

                    PizzaApp(
                        navController = navController,
                        viewModel = viewModel,
                        timerViewModel = timerViewModel,
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

// ENUM with categories
enum class MyPizzaScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    First(title = R.string.first_clue),
    Second(title = R.string.first_clue),
    Third(title = R.string.first_clue),
    Fourth(title = R.string.first_clue),
    Fifth(title = R.string.first_clue),
}


