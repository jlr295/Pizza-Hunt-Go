package com.example.globalpizzahuntgame.ui
import com.example.globalpizzahuntgame.MyPizzaScreen

data class PizzaUiState (
    var openAlertDialog: Boolean = false,
    val currentPage: MyPizzaScreen = MyPizzaScreen.Start,
    val currHintText: Int = 0,
    val currHintTitle: Int = 0
)