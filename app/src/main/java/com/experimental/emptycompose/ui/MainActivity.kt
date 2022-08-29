package com.experimental.emptycompose.ui

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.experimental.emptycompose.ui.bottomSheet.BottomSheetContent
import com.experimental.emptycompose.ui.data.BottomSheetType
import com.experimental.emptycompose.ui.data.lisOfFullRates
import com.experimental.emptycompose.ui.data.listOfDrawer
import com.experimental.emptycompose.ui.navigation.AppBar
import com.experimental.emptycompose.ui.navigation.DrawerBody
import com.experimental.emptycompose.ui.navigation.DrawerHeader
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setSoftInputMode(SOFT_INPUT_ADJUST_RESIZE)

        setContent {
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()

            var id by remember { mutableStateOf(0) }
            val getIdForDialogs = { index: Int -> id = index }

            val modalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
            val onBottomSheetValue = { modalBottomSheetState }

            var bottomSheetType by remember { mutableStateOf(BottomSheetType.BUY) }
            val getBottomSheetState = { state: BottomSheetType -> bottomSheetType = state }

            val openDialog = remember { mutableStateOf(false) }
            val dialogListener = { state: Boolean -> openDialog.value = state }

            val keyboardController = LocalSoftwareKeyboardController.current

            var tabIndex by remember{ mutableStateOf(-1)}
            val changeTabIndex = {updateIndex:Int -> tabIndex = updateIndex}

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Share this App with friends")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            val context = LocalContext.current

            ModalBottomSheetLayout(
                sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                sheetState = modalBottomSheetState,
                sheetContent = {
                    BottomSheetContent(item = lisOfFullRates[id], type = bottomSheetType, bottomSheetState = onBottomSheetValue)
                }
            ) {
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(
                            onItemClick = {context.startActivity(shareIntent)},
                            onNavigationIconClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            })
                    },
                    drawerElevation = 0.dp,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOfDrawer,
                            onItemClick = {
                                if (it.id.toInt() > 0){
                                    tabIndex = 1
                                    scope.launch {
                                        scaffoldState.drawerState.close()
                                    }
                                }else{
                                    tabIndex = 0
                                    scope.launch {
                                        scaffoldState.drawerState.close()
                                    }
                                }
                            },
                            modifier = Modifier.padding(16.dp)
                        )
                    }) {
                    Column {
                        CustomTabs(
                            tabIndex,
                            changeTabIndex,
                            onBottomSheetValue,
                            getIdForDialogs,
                            getBottomSheetState,
                            dialogListener
                        )
                    }
                }
            }
            if (openDialog.value) {
                CallDialog(dialogListener, item = lisOfFullRates[id])
            }
            if (!modalBottomSheetState.isVisible) {
                keyboardController?.hide()
            }
        }
    }
}



