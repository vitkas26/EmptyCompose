package com.experimental.emptycompose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextFieldSell(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    placeholderText: String = "1",
    fontSize: TextUnit = 28.sp
) {
    var text by rememberSaveable { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    BasicTextField(modifier = modifier
        .background(
            MigGrey,
            MaterialTheme.shapes.small,
        )
        .fillMaxWidth(),
        value = text,
        onValueChange = {
            text = it
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()
        }),
        singleLine = true,
        cursorBrush = SolidColor(Color.Transparent),
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
                Box(Modifier.weight(1f)) {
                    if (text.isEmpty()) Text(
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