package com.experimental.emptycompose.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.experimental.emptycompose.theme.MigBackground
import com.experimental.emptycompose.theme.MigBlue
import com.experimental.emptycompose.ui.data.Points

@Composable
fun Addresses(item: Points) {
    Row(
        Modifier
            .background(Color.White)
    ) {
        Column(
            Modifier
                .weight(1f)
                .clip(RoundedCornerShape(4.dp))
                .height(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.heading,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MigBackground
            )
            Text(
                text = item.kilometers,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Row(
            Modifier
                .weight(1f)
                .clip(RoundedCornerShape(4.dp))
                .height(50.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = item.whatsAppIcon),
                contentDescription = "send message by Whatsapp",
                modifier = Modifier.padding(end = 12.dp)
            )
            Image(
                imageVector = item.phoneIcon,
                contentDescription = "show phone numbers",
                colorFilter = ColorFilter.tint(MigBlue),
                modifier = Modifier.padding(end = 12.dp)
            )
            Image(
                imageVector = item.mapRoute,
                contentDescription = "show in a map",
                colorFilter = ColorFilter.tint(MigBlue),
                modifier = Modifier.padding(end = 12.dp)
            )
        }
    }
}
