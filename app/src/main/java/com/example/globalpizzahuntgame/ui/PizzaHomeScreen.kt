package com.example.globalpizzahuntgame.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.globalpizzahuntgame.R
import com.example.globalpizzahuntgame.ui.components.SubmitButton
import com.example.globalpizzahuntgame.ui.components.TextCard


@Composable
fun PizzaHomeScreen(
    onStartClick:() -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painterResource(R.drawable.pizza_icon),
            contentDescription = stringResource(R.string.pizza_slice),
            modifier = Modifier
                .size(100.dp)
        )
        TextCard(
            content = "${stringResource(R.string.scenario)}\n\n" +
                "${stringResource(R.string.directions)}",
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium))
        )

        SubmitButton(
            onClick = { onStartClick() },
            buttonText = R.string.start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)))
    }
}



@Composable
private fun HomeScreenContent(

) {

}