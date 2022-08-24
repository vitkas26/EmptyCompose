package com.experimental.emptycompose.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id:String,
    val title:String,
    val icon:ImageVector,
    val contentDescription: String,
    val endIcon:ImageVector = Icons.Default.KeyboardArrowRight
)
