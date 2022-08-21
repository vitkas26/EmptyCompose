package com.experimental.emptycompose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.experimental.emptycompose.ui.theme.data.Rates

@Composable
fun MainRates(item: Rates) {
    var color = Color.White
    if (item.name == "GOLD") {
        color = Color.Yellow
    }
    Row(
        Modifier
            .padding(start = 50.dp, end = 50.dp, top = 8.dp)
    ) {
        Column(
            Modifier
                .clickable {
                }
                .weight(1f)
                .clip(RoundedCornerShape(4.dp))
                .background(Color.White)
                .height(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.firstNum,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MigBackground
            )
        }
        Spacer(modifier = Modifier.padding(end = 20.dp))
        Column(
            Modifier
                .clickable {}
                .weight(1f)
                .height(50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = item.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = color
            )
        }
        Spacer(modifier = Modifier.padding(end = 20.dp))
        Column(
            Modifier
                .weight(1f)
                .clip(RoundedCornerShape(4.dp))
                .background(Color.White)
                .height(50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = item.secondNum,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MigBackground
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun createBottomSheet() {
    BottomSheetScaffold(
        sheetContent = {BottomSheetContent()}
    ) {
        
    }


}

@Composable
fun BottomSheetContent(){
    Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center){

    }
}