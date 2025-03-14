package com.example.globalpizzahuntgame.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.example.globalpizzahuntgame.R

@Composable
fun HintDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: Int,
    dialogText: Int,
    icon: ImageVector
){
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Hint")
        },
        title = {
            Text(text = stringResource(dialogTitle))
        },
        text = {
            Text(text = stringResource(dialogText))
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            )
            {
                Text(stringResource(R.string.cancel))
            }
                        },
    )
}