package com.example.globalpizzahuntgame.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.globalpizzahuntgame.R
import com.example.globalpizzahuntgame.ui.components.HintButton
import com.example.globalpizzahuntgame.ui.components.SubmitButton
import com.example.globalpizzahuntgame.ui.components.TextCard
import com.example.globalpizzahuntgame.ui.components.TimerScreen
import com.example.globalpizzahuntgame.ui.components.formatTime

@Composable
fun ClueScreen(
    onCancel:() -> Unit,
    onHintClick: (Boolean) -> Unit,
    onFoundIt: () -> Unit,
    cluePhoto: Int,
    clueText: String,
    timerValue: Long,
    //location: Location,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Absolute.Right,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            TimerScreen(
                timerValue.formatTime(),
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_medium)))
            HintButton(
                onClick = { onHintClick(true) },
                modifier = Modifier
                    .size(60.dp)
            )
        }
        Image(
            painter = painterResource(cluePhoto),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            contentDescription = stringResource(R.string.Elysian_Fields_Title),
            modifier = Modifier
                .padding(
                    dimensionResource(R.dimen.padding_medium)
                )
                .fillMaxWidth()
                .height(400.dp)
                .align(Alignment.End)
                .weight(.5f)
        )

        TextCard(
            content = clueText,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium))
                .fillMaxWidth()
                .weight(.2f)
        )

        Column(
            verticalArrangement =  Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .weight(.2f)
        ) {

            SubmitButton(
                onClick = { onFoundIt() },
                buttonText = R.string.found_it,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
                    .weight(.4f)
            )

            SubmitButton(
                onClick = { onCancel () },
                buttonText = R.string.cancel,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
                    .weight(.4f)
            )
        }
    }
}

