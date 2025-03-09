package com.example.globalpizzahuntgame.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import com.example.globalpizzahuntgame.MyPizzaScreen

class PizzaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PizzaUiState())
    val uiState: StateFlow<PizzaUiState> = _uiState

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        PizzaUiState()
    }

    fun updateCurrentScreen(screen: MyPizzaScreen) {
        _uiState.update {
            it.copy(
                currentPage = screen
            )
        }
    }


}

