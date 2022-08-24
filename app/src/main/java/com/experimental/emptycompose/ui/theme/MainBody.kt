package com.experimental.emptycompose.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.experimental.emptycompose.ui.theme.data.BottomSheetType
import com.experimental.emptycompose.ui.theme.data.Rates
import com.experimental.emptycompose.ui.theme.data.lisOfFullRates
import com.experimental.emptycompose.ui.theme.data.listOfRates

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainBody(
    onBottomSheetValue: () -> ModalBottomSheetState,
    getIdForBottomSheet: (Int) -> Unit,
    getBottomSheetState: (BottomSheetType) -> Unit,
    dialogListener: (Boolean) -> Unit
) {
    var expandSize by remember { mutableStateOf(0) }

    val lazyItems: List<Rates> = if (expandSize == 1) {
        lisOfFullRates
    } else {
        listOfRates
    }

    LazyColumn(Modifier.fillMaxHeight(),
    ) {
        item { MainHeader() }
        items(lazyItems) { item ->
            MainRates(item, onBottomSheetValue, getIdForBottomSheet, getBottomSheetState, dialogListener)
        }
        item { Spacer(modifier = Modifier.padding(bottom = 20.dp)) }
        item {
            Column(
                Modifier
                    .fillMaxWidth()
                    .clickable {
                        expandSize = 1
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(bottom = 20.dp))
                Text(text = "Дополнительные валюты", color = Color.White)
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "DropDown",
                    tint = Color.White
                )
            }
            MainFooter()
        }
    }
}



//    var expand by remember { mutableStateOf(0) }
//
//    MainHeader()
//
//    if (expand == 0) {
//        for (item in itemRatesList) {
//            MainRates(item = item, expandBottomSheet, lambdaBottomSheet)
//        }
//    } else {
//        for (item in itemRatesList) {
//            MainRates(
//                item = item,
//                expandBottomSheet = expandBottomSheet,
//                lambdaBottomSheet = lambdaBottomSheet
//            )
//        }
//        for (item in itemAdditional) {
//            MainRates(
//                item = item,
//                expandBottomSheet = expandBottomSheet,
//                lambdaBottomSheet = lambdaBottomSheet
//            )
//        }
//    }
//
//    Column(
//        Modifier
//            .fillMaxWidth()
//            .clickable {
//                expand = 1
//            },
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Spacer(modifier = Modifier.padding(bottom = 20.dp))
//        Text(text = "Дополнительные валюты", color = Color.White)
//        Icon(
//            imageVector = Icons.Default.ArrowDropDown,
//            contentDescription = "DropDown",
//            tint = Color.White
//        )
//    }
//    MainFooter()
//}