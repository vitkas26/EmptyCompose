package com.experimental.emptycompose.ui.bottomSheet

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.experimental.emptycompose.theme.MigBlue
import com.experimental.emptycompose.theme.MigGrey
import com.experimental.emptycompose.ui.data.Rates

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomTextFieldBuy(
    item: String,
    removeSellValue: () -> Unit,
    getSellValue: String,
    sendValue: (String)-> Unit,
    modifier: Modifier = Modifier,
    bottomSheetState: () -> ModalBottomSheetState,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    placeholderText: String,
    fontSize: TextUnit = 28.sp
) {

    var buyAmount by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed: Boolean by interactionSource.collectIsPressedAsState()

    if(isPressed||!bottomSheetState.invoke().isVisible){
        removeSellValue()
        buyAmount = ""
    }

    BasicTextField(
        modifier = modifier
            .background(
                MigGrey,
                MaterialTheme.shapes.small,
            )
            .fillMaxWidth(),
        value = getSellValue.ifEmpty { buyAmount },
        onValueChange = {
            buyAmount = it
            sendValue((it.ifEmpty { "1" }.toDouble().toInt()/item.toDouble().toInt()).toString())
        },
        interactionSource = interactionSource,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()
        }),
        singleLine = true,
        cursorBrush = SolidColor(Color.Black),
        textStyle = LocalTextStyle.current.copy(
            color = MigBlue,
            fontSize = fontSize,
            textAlign = TextAlign.Center
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) leadingIcon()
                Box(
                    Modifier
                        .weight(1f)
                ) {
                    if (buyAmount.isEmpty() && getSellValue.isEmpty()) Text(
                        placeholderText,
                        Modifier
                            .align(Alignment.Center)
                            .padding(start = 15.dp),
                        style = LocalTextStyle.current.copy(
                            color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f),
                            fontSize = fontSize,
                        ),
                    )
                    innerTextField()
                }
                if (trailingIcon != null) trailingIcon()
            }
        }
    )
}