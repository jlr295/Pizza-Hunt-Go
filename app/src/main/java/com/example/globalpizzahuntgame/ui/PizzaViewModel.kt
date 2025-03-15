package com.example.globalpizzahuntgame.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globalpizzahuntgame.MyPizzaScreen
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

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

    fun setAlertDialog(
        bool: Boolean,
    ){
        _uiState.update {
            it.copy(
                openAlertDialog = bool,
            )
        }
    }

    fun setFoundIngredientDialog(
        bool: Boolean,
    ){
        _uiState.update {
            it.copy(
                openFoundDialog = bool,
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

    fun setFoundIngredientText(
        currIngredientText: Int,
        currIngredientTitle: Int,
        currIngredientPhoto: Int
    ){
        _uiState.update {
            it.copy(
                foundIngredientMessage = currIngredientText,
                foundIngredientPic = currIngredientPhoto,
                foundIngredientTitle = currIngredientTitle
            )
        }
    }

    fun getAlertDialog(): Boolean{
         return uiState.value.openAlertDialog
    }

    fun getAlertText(): Int{
        return uiState.value.currHintText
    }

    fun getAlertTitle(): Int{
        return uiState.value.currHintTitle
    }

    fun getIngredientPhoto(): Int{
        return uiState.value.foundIngredientPic
    }

    fun getIngredientMessage(): Int{
        return uiState.value.foundIngredientMessage
    }

}

class TimerViewModel: ViewModel() {
    private val _timer = MutableStateFlow(0L)
    val timer = _timer.asStateFlow()

    private var timerJob: Job? = null

    fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (true) {
                delay(1000)
                _timer.value ++
            }
        }
    }

    fun pauseTimer() {
        timerJob?.cancel()
    }

    fun stopTimer() {
        _timer.value = 0
        timerJob?.cancel()
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }




}

