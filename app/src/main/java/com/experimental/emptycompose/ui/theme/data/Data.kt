package com.experimental.emptycompose.ui.theme.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share

val listOfRates = mutableListOf(
    Rates("475.5", "USD", "479.5", "Доллар США", 0),
    Rates("480.5", "EUR", "486.5", "Евро", 1),
    Rates("475.5", "RUB", "479.5", "Российский рубль", 2),
    Rates("475.5", "KGS", "479.5", "Киргизский сом", 3),
    Rates("475.5", "GBP", "479.5", "Фунт Стерлингов", 4),
    Rates("475.5", "CNY", "479.5", "Китайский Юань", 5),
    Rates("475.5", "GOLD", "479.5", "Золотый слитки 1гр.", 6),
)

val lisOfFullRates = mutableListOf(
    Rates("475.5", "USD", "479.5", "Доллар США", 0),
    Rates("480.5", "EUR", "486.5", "Евро", 1),
    Rates("475.5", "RUB", "479.5", "Российский рубль", 2),
    Rates("475.5", "KGS", "479.5", "Киргизский сом", 3),
    Rates("475.5", "GBP", "479.5", "Фунт Стерлингов", 4),
    Rates("475.5", "CNY", "479.5", "Китайский Юань", 5),
    Rates("475.5", "GOLD", "479.5", "Золотый слитки 1гр.", 6),
    Rates("475.5", "CHF", "479.5", "Швейцарский франк", 7),
    Rates("475.5", "HKD", "479.5", "Гонконгский доллар", 8),
    Rates("475.5", "GEL", "479.5", "Грузинский лари", 9),
    Rates("475.5", "AED", "479.5", "Дирхам ОАЭ", 10),
    Rates("475.5", "INR", "479.5", "Индийская Рупия", 11),
    Rates("475.5", "CAD", "479.5", "Канадский доллар", 12),
    Rates("475.5", "MYR", "479.5", "Малайзийский ринггит", 13),
    Rates("475.5", "PLN", "479.5", "Польский злотый", 14),
    Rates("522.5", "THB", "562.5", "Тайский бат", 15),
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

enum class BottomSheetType {
    SELL,
    BUY
}