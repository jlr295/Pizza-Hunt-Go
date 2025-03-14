package com.example.globalpizzahuntgame.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.example.globalpizzahuntgame.MyPizzaScreen
import com.example.globalpizzahuntgame.ui.components.HintDialog
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

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
    @Composable
    fun DisplayHint(
        onDismissRequest: () -> Unit,
        onConfirmation: () -> Unit
    ){
        HintDialog(
            onDismissRequest =  { onDismissRequest() },
            onConfirmation =  { onConfirmation() },
            dialogTitle = getAlertTitle(),
            dialogText = getAlertText(),
            icon = Icons.Default.Search
        )
    }

    fun setAlertDialog(
        bool: Boolean,
    ){
        _uiState.update {
            it.copy(
                openAlertDialog = bool,
            )
        }
    }

    fun setAlertText(
        currHintText: Int,
        currHintTitle: Int
    ){
        _uiState.update {
            it.copy(
                currHintText = currHintText,
                currHintTitle = currHintTitle
            )
        }
    }

    fun getAlertDialog(): Boolean{
         return uiState.value.openAlertDialog
    }

    private fun getAlertText(): Int{
        return uiState.value.currHintText
    }

    private fun getAlertTitle(): Int{
        return uiState.value.currHintTitle
    }
}

