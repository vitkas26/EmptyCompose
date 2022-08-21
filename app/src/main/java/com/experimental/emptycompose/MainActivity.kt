package com.experimental.emptycompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.experimental.emptycompose.ui.theme.*
import com.experimental.emptycompose.ui.theme.data.Data
import com.experimental.emptycompose.ui.theme.data.MenuItem
import com.experimental.emptycompose.ui.theme.navigation.customShape
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            Scaffold(
                scaffoldState = scaffoldState,
                topBar = {
                    AppBar(onNavigationIconClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    })
                },
                drawerShape = customShape(),
                drawerElevation = 0.dp,
                drawerContent = {
                    DrawerHeader()
                    DrawerBody(
                        items = Data.listOfDrawer,
                        onItemClick = {
                            Toast.makeText(this@MainActivity, it.title, Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.padding(16.dp)
                    )
                }) {
                Column() {
                    CustomTabs()
                }
            }
        }
    }
}
