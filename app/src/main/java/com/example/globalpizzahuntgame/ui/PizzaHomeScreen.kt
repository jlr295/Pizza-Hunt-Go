package com.example.globalpizzahuntgame.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.globalpizzahuntgame.R
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
        TextCard(
            content = "${stringResource(R.string.scenario)}\n\n" +
                "${stringResource(R.string.directions)}",
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium))
        )
    }
}



@Composable
private fun HomeScreenContent(

) {

}