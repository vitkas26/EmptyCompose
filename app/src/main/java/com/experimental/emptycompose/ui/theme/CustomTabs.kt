package com.experimental.emptycompose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.experimental.emptycompose.MainActivity
import com.experimental.emptycompose.ui.theme.data.Data
import com.experimental.emptycompose.ui.theme.data.Rates

@Composable
fun CustomTabs() {
    var selectedIndex by remember { mutableStateOf(0) }
    val list = listOf("Курсы Валют", "Ближайшие пункты")

    val listRates = Data.listOfRates
    val listAdditional = Data.lisOfAdditional

    TabRow(selectedTabIndex = selectedIndex,
        backgroundColor = MigGrey,
        modifier = Modifier
            .fillMaxHeight(0.06f)
            .padding(horizontal = 18.dp)
            .clip(RoundedCornerShape(20)),
        indicator = {
        }
    ) {
        list.forEachIndexed { index, text ->
            val selected = selectedIndex == index
            Tab(
                modifier = if (selected) Modifier
                    .padding(vertical = 2.dp, horizontal = 2.dp)
                    .clip(RoundedCornerShape(20))
                    .background(
                        White
                    )
                else Modifier
                    .padding(vertical = 2.dp, horizontal = 2.dp)
                    .clip(RoundedCornerShape(20))
                    .background(
                        MigGrey
                    ),
                selected = selected,
                onClick = { selectedIndex = index },
                text = {
                    Text(
                        text = text,
                        color = MigGreyText,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    }
    Column(
        modifier = Modifier
            .padding(top = 16.dp, start = 18.dp, end = 18.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MigBackground)
            .verticalScroll(rememberScrollState())
    ) {
        when (selectedIndex) {
            0 -> MainBody(listRates, listAdditional)
            else -> MainHeader()
        }
    }
}




