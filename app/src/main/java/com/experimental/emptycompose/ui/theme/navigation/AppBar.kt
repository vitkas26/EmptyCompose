package com.experimental.emptycompose.ui.theme.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.experimental.emptycompose.R
import com.experimental.emptycompose.ui.theme.MigBlue

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp, color = MigBlue, fontWeight = FontWeight.Bold),
) {
    TopAppBar(
        title = {},
        backgroundColor = Color.White,
        contentColor = MigBlue,
        elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Toggle Drawer")
            }
        },
        actions = {
            IconButton(onClick = { "Clicked" }) {
                Image(
                    painterResource(id = R.drawable.ic_share_svgrepo_com),
                    contentDescription = "Share App", Modifier.size(20.dp)
                )
            }
        }
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Главная", style = itemTextStyle)
    }
}



