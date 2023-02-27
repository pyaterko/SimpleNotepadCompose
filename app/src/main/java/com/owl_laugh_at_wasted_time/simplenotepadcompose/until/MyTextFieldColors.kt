package com.owl_laugh_at_wasted_time.simplenotepadcompose.until

import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun myTextFieldColors(): TextFieldColors {
    return TextFieldDefaults.textFieldColors(
        textColor = MaterialTheme.colors.onPrimary,
        disabledTextColor = Color.Black,
        backgroundColor =  MaterialTheme.colors.background,
        cursorColor = Color.Blue,
        errorCursorColor = Color.Red,
        unfocusedLabelColor = Color.Gray,
        focusedLabelColor = Color.Blue,
        leadingIconColor = Color.Red,
        focusedIndicatorColor = Color.Blue,
        unfocusedIndicatorColor = Color.Gray,
        errorIndicatorColor = Color.Red,
        disabledIndicatorColor = Color.Red,
        disabledLeadingIconColor = Color.Red,
        errorLeadingIconColor = Color.Red,
        trailingIconColor = Color.Blue,
        disabledTrailingIconColor = Color.Red,
        errorTrailingIconColor = Color.Red,
        disabledLabelColor = Color.Red,
        errorLabelColor = Color.Blue,
        placeholderColor = Color.Blue,
        disabledPlaceholderColor = Color.Blue,
    )
}
