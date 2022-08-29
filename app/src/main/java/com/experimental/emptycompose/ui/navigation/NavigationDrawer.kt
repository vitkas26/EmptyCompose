package com.experimental.emptycompose.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.experimental.emptycompose.R
import com.experimental.emptycompose.theme.MigBlue
import com.experimental.emptycompose.ui.data.MenuItem

@Composable
fun DrawerHeader(
    itemTextStyle: TextStyle =
        TextStyle(
            fontSize = 24.sp,
            color = MigBlue,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    )
    {
        Image(
            painterResource(id = R.drawable.mig), contentDescription = "icon",
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 20.dp)
                .size(50.dp)
        )
        Text(text = "МиГ", style = itemTextStyle)
    }
    Row {
        Divider(
            color = MigBlue,
            modifier = Modifier
                .fillMaxWidth(0.7f),
            thickness = 0.8.dp,
        )
    }
}


@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 16.sp, color = MigBlue),
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth()
                .clickable {
                    onItemClick(item)
                }
            ) {
                Column(Modifier.weight(1f)) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.contentDescription,
                        tint = MigBlue
                    )
                }
                Column(Modifier.weight(3f)) {
                    Text(
                        text = item.title,
                        style = itemTextStyle
                    )
                }
                Column(Modifier.weight(1f)) {
                    Icon(
                        imageVector = item.endIcon,
                        contentDescription = item.contentDescription,
                        tint = MigBlue
                    )
                }

            }
        }
    }
}