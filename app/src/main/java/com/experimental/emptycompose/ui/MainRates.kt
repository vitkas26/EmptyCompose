package com.experimental.emptycompose.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.experimental.emptycompose.ui.data.BottomSheetType
import com.experimental.emptycompose.ui.data.Rates
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainRates(
    item: Rates,
    onBottomSheetValue: () -> ModalBottomSheetState,
    getIdForBottomSheet: (Int) -> Unit,
    getBottomSheetState: (BottomSheetType) -> Unit,
    dialogListener: (Boolean) -> Unit
) {
    var color = Color.White
    val scopeBottomSheet = rememberCoroutineScope()
    val scopeBottomSheetId = rememberCoroutineScope()

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
                    scopeBottomSheet.launch {
                        onBottomSheetValue
                            .invoke()
                            .show()
                    }
                    scopeBottomSheetId.launch {
                        getIdForBottomSheet(item.id)
                        getBottomSheetState(BottomSheetType.BUY)
                    }
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
                .clickable {
                    getIdForBottomSheet(item.id)
                    dialogListener(true)
                }
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
                .clickable {
                    scopeBottomSheet.launch {
                        getIdForBottomSheet(item.id)
                        getBottomSheetState(BottomSheetType.SELL)
                        onBottomSheetValue
                            .invoke()
                            .show()
                    }
                }
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