package com.experimental.emptycompose.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.experimental.emptycompose.data.BottomSheetType
import com.experimental.emptycompose.data.Rates

@Composable
fun BottomSheetContent(
    type: BottomSheetType,
    item: Rates
) {
    val getString = listOf("Получить", "Купить")
    val sellString = listOf("Продать", "Требуется")


    val placeholderText: String = when (type) {
        BottomSheetType.BUY -> item.firstNum
        else -> {
            item.secondNum
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
    ) {
        Text(
            item.fullName + " (${item.name})",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(bottom = 130.dp)
        )
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Закрыть",
            tint = MigGrey,
            modifier = Modifier
                .align(Alignment.TopEnd)
        )
        Text(
            text = "По курсу", fontSize = 16.sp, color = MigGreyText,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(bottom = 75.dp)
        )
        Text(
            text = when (type) {
                BottomSheetType.BUY -> item.firstNum
                else -> {
                    item.secondNum
                }
            },
            fontSize = 24.sp,
            color = MigBlue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(bottom = 15.dp)
        )
        Text(
            text = when (type) {
                BottomSheetType.BUY -> sellString[0]
                else -> {
                    getString[0]
                }
            },
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 45.dp)
        )
        CustomTextFieldSell(
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Icon",
                    Modifier
                        .padding(4.dp)
                        .fillMaxHeight(0.7f)
                )
            },
            modifier = Modifier
                .height(40.dp)
                .width(170.dp)
                .align(Alignment.BottomStart)
        )
        Text(
            text = when (type) {
                BottomSheetType.BUY -> getString[1]
                else -> {
                    sellString[1]
                }
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 45.dp)
        )
        CustomTextFieldBuy(
            placeholderText = placeholderText,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Icon",
                    Modifier
                        .padding(4.dp)
                        .fillMaxHeight(0.7f)
                )
            },
            modifier = Modifier
                .height(40.dp)
                .width(170.dp)
                .align(Alignment.BottomEnd)
        )
    }
}



