package com.example.globalpizzahuntgame.ui
import com.example.globalpizzahuntgame.MyPizzaScreen

data class PizzaUiState (
    var openAlertDialog: Boolean = false,
    var openFoundDialog: Boolean = false,
    val currentPage: MyPizzaScreen = MyPizzaScreen.Start,
    val currHintText: Int = 0,
    val currHintTitle: Int = 0,
    val foundIngredientPic: Int = 0,
    val foundIngredientTitle: Int = 0,
    val foundIngredientMessage: Int = 0
)