package com.experimental.emptycompose.ui.data

import android.graphics.drawable.Icon
import androidx.compose.ui.graphics.vector.ImageVector

data class Points(
    val heading:String,
    val kilometers:String,
    val address:String,
    val whatsAppIcon: Int,
    val phoneIcon: ImageVector,
    val mapRoute: ImageVector
)
