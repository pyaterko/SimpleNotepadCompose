package com.owl_laugh_at_wasted_time.simplenotepadcompose.until

import androidx.compose.material.CheckboxColors
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable


@Composable
fun MyCheckBoxColors(): CheckboxColors {
    return CheckboxDefaults.colors(
        checkedColor = MaterialTheme.colors.onSecondary,
        uncheckedColor = MaterialTheme.colors.onPrimary
    )
}