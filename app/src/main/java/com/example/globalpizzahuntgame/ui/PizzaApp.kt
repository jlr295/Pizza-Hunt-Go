package com.example.globalpizzahuntgame.ui


import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.globalpizzahuntgame.ui.utils.ReplyNavigationType
import com.example.globalpizzahuntgame.ui.utils.ReplyContentType

@Composable
fun PizzaApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier
) {
    val navigationType: ReplyNavigationType
    val contentType: ReplyContentType

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = ReplyNavigationType.NAVIGATION_RAIL
            contentType = ReplyContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = ReplyNavigationType.PERMANENT_NAVIGATION_DRAWER
            contentType = ReplyContentType.LIST_AND_DETAIL
        }
        else -> {
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }
    }

    PizzaHomeScreen(
        navigationType = navigationType,
        contentType = contentType,

    )


}