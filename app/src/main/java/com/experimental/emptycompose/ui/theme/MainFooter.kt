package com.experimental.emptycompose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainFooter() {
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 30.dp, bottom = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Забронировать сумму/курс",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "Лицензия АГФ НБ РК №7520029 от 23.09.2020",
            fontSize = 12.sp,
            fontWeight = FontWeight.Thin,
            color = Color.Blue
        )
    }
}