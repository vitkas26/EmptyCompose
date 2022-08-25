package com.experimental.emptycompose.ui

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
import com.experimental.emptycompose.theme.MainHeader
import com.experimental.emptycompose.ui.data.BottomSheetType
import com.experimental.emptycompose.ui.data.Rates
import com.experimental.emptycompose.ui.data.lisOfFullRates
import com.experimental.emptycompose.ui.data.listOfRates

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

    LazyColumn(
        Modifier.fillMaxHeight(),
    ) {
        item { MainHeader() }
        items(lazyItems) { item ->
            MainRates(
                item,
                onBottomSheetValue,
                getIdForBottomSheet,
                getBottomSheetState,
                dialogListener
            )
        }
        if (lazyItems.size == listOfRates.size) {
            item {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .clickable {
                            expandSize = 1
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Дополнительные валюты", color = Color.White, modifier = Modifier.padding(top = 20.dp))
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "DropDown",
                        tint = Color.White
                    )
                }
                MainFooter()
            }
        } else {
            item {
                Spacer(modifier = Modifier.padding(bottom = 20.dp))
                MainFooter()
            }
        }
    }
}