package com.experimental.emptycompose.ui.theme.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share

object Data {
    val listOfRates = mutableListOf(
        Rates("475.5", "USD", "479.5"),
        Rates("480.5", "EUR", "486.5"),
        Rates("475.5", "RUB", "479.5"),
        Rates("475.5", "KGS", "479.5"),
        Rates("475.5", "GBP", "479.5"),
        Rates("475.5", "CNY", "479.5"),
        Rates("475.5", "GOLD", "479.5"),
    )

    val lisOfAdditional = mutableListOf(
        Rates("475.5", "CHF", "479.5"),
        Rates("475.5", "HKD", "479.5"),
        Rates("475.5", "GEL", "479.5"),
        Rates("475.5", "GEL", "479.5"),
        Rates("475.5", "GEL", "479.5"),
        Rates("475.5", "HKD", "479.5"),
        Rates("475.5", "GEL", "479.5"),
        Rates("475.5", "GEL", "479.5"),
        Rates("522.5", "SPB", "562.5"),
    )

    val listOfDrawer =
        mutableListOf(
            MenuItem(
                id = "1",
                title = "Главная",
                contentDescription = "Main menu",
                icon = Icons.Default.Home
            ),
            MenuItem(
                id = "2",
                title = "Забронировать сумму/курс",
                contentDescription = "Main menu",
                icon = Icons.Default.Home
            ),
            MenuItem(
                id = "3",
                title = "Золотые слитки НБ РК",
                contentDescription = "Main menu",
                icon = Icons.Default.Home
            ),
            MenuItem(
                id = "4",
                title = "Ближайшие пункты",
                contentDescription = "Main menu",
                icon = Icons.Default.Share,
            ),
        )
}