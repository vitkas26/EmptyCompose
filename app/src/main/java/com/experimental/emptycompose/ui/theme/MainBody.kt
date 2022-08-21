package com.experimental.emptycompose.ui.theme

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.experimental.emptycompose.MainActivity
import com.experimental.emptycompose.R
import com.experimental.emptycompose.ui.theme.data.Rates
import org.intellij.lang.annotations.JdkConstants

@Composable
fun MainBody(itemRatesList: MutableList<Rates>, itemAdditional: List<Rates>) {

//    var expandSize by remember { mutableStateOf(0.97f) }
//
//    LazyColumn (Modifier.fillMaxHeight(expandSize)){
//        item { MainHeader() }
//        items(itemRatesList) { item ->
//            MainRates(item)
//        }
//        item { Spacer(modifier = Modifier.padding(bottom = 20.dp)) }
//        item {
//            Column(
//                Modifier
//                    .fillMaxWidth()
//                    .clickable {
//                        expandSize += 0.5f
//                    },
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Spacer(modifier = Modifier.padding(bottom = 20.dp))
//                Text(text = "Дополнительные валюты", color = Color.White)
//                Icon(
//                    imageVector = Icons.Default.ArrowDropDown,
//                    contentDescription = "DropDown",
//                    tint = Color.White
//                )
//            }
//            MainFooter()
//        }
//    }

    var expand by remember{ mutableStateOf(0)}

    MainHeader()

    if (expand==0){
        for (item in itemRatesList) {
            MainRates(item = item)
        }
    }else{
        for (item in itemRatesList) {
            MainRates(item = item)
        }
        for (item in itemAdditional) {
            MainRates(item = item)
        }
    }

    Column(
        Modifier
            .fillMaxWidth()
            .clickable {
                       expand = 1
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

