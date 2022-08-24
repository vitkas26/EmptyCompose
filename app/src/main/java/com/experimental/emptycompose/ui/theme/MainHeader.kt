package com.experimental.emptycompose.ui.theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.experimental.emptycompose.R

@Composable
fun MainHeader() {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 8.dp)
    ) {
        Column(
            Modifier
                .weight(1f)
                .padding(vertical = 18.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "КУРСЫ", color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(vertical = 6.dp))
            Text(
                text = "ЗОЛОТЫЕ",
                color = Color.Yellow,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "СЛИТКИ",
                color = Color.Yellow,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(id = R.drawable.mig),
                contentDescription = "Logo",
                Modifier
                    .fillMaxHeight(0.2f)
                    .clip(RoundedCornerShape(55.dp))
            )
        }
        Column(
            Modifier
                .weight(1f)
                .padding(vertical = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "ВАЛЮТ", color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(vertical = 6.dp))
            Text(
                text = "Национального банка РК",
                textAlign = TextAlign.Center,
                color = Color.Yellow,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
        Row(Modifier.fillMaxWidth().padding(vertical = 8.dp), horizontalArrangement = Arrangement.Center) {
            Text(
                text = "на 22 августа 2022 10:23",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
    }
}
