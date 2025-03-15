package com.example.globalpizzahuntgame.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun TimerScreen(
    timerValue: String,
    modifier: Modifier
){
    Box {
        Text(
            timerValue,
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier
        )
    }
}


fun Long.formatTime(): String {
    val hours = this / 3600
    val minutes = (this % 3600) / 60
    val seconds = (this % 60)
    return String.format(locale = java.util.Locale.getDefault(), format = "%02d:%02d:%02d", args = arrayOf(hours, minutes, seconds))
}