package com.example.globalpizzahuntgame.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.dropUnlessResumed
import com.example.globalpizzahuntgame.R
import com.example.globalpizzahuntgame.ui.components.HintButton
import com.example.globalpizzahuntgame.ui.components.SubmitButton
import com.example.globalpizzahuntgame.ui.components.TextCard

@Composable
fun ClueScreen(
    onNextClick:() -> Unit,
    onHintClick:() -> Unit,
    onSubmitLocation: () -> Unit,
    cluePhoto: Int,
    clueText: String,
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
            HintButton(
                onClick = { onHintClick() },
                modifier = Modifier
                    .size(60.dp)
            )
        }
        Image(
            painter = painterResource(cluePhoto),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            contentDescription = stringResource(R.string.elysian_fields_1846),
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
                onClick = { onNextClick() },
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
                    .weight(.4f)
            )

            SubmitButton(
                onClick = { onSubmitLocation() },
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
                    .weight(.4f)
            )
        }


    }}
