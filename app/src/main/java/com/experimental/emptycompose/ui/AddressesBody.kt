package com.experimental.emptycompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.experimental.emptycompose.ui.navigation.Addresses
import com.experimental.emptycompose.theme.MainHeader
import com.experimental.emptycompose.theme.MigGrey
import com.experimental.emptycompose.ui.data.listOfPoints

@Composable
fun AddressesBody() {
    LazyColumn(
        Modifier.fillMaxHeight().padding(20.dp)
        .background(Color.White),
    verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .padding(start = 12.dp, end = 12.dp)
            ) {
                Text(
                    text = "Ближайшие пункты",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 18.dp, start = 12.dp, bottom = 12.dp)
                )
                Divider(color = MigGrey, thickness = 1.dp)
            }
        }
        items(listOfPoints) { item ->
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
            ) {
                Addresses(item)
            }
            Divider(color = MigGrey, thickness = 1.dp)
        }
        item {
            MainFooter()
        }
    }
}