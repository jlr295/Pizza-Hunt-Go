package com.example.globalpizzahuntgame.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.globalpizzahuntgame.R


@Composable
fun SubmitButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier)
{
    OutlinedButton (
        onClick = { onClick() },
        colors = ButtonColors(
            MaterialTheme.colorScheme.onSurfaceVariant ,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
            disabledContentColor = MaterialTheme.colorScheme.onSecondary
        ),
        modifier = modifier
    ){
        Text(
            stringResource(R.string.start),
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_extrasmall))
        )
    }
}

@Composable
fun HintButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier)
{
    SmallFloatingActionButton(
        onClick = { onClick() },
        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = modifier
    ){
        Icon(
            imageVector = Icons.Filled.Info,
            contentDescription = stringResource(R.string.hint_button),
            modifier = Modifier.size(20.dp)
        )
    }
}