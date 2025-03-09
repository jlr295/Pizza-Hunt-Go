package com.example.globalpizzahuntgame.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.globalpizzahuntgame.R
import com.example.globalpizzahuntgame.ui.utils.PizzaContentType
import com.example.globalpizzahuntgame.ui.utils.PizzaNavigationType


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
        Text(
            text = "${stringResource(R.string.scenario)}\n\n" +
                    "${stringResource(R.string.directions)}",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        )

    }
}



@Composable
private fun HomeScreenContent(

) {

}