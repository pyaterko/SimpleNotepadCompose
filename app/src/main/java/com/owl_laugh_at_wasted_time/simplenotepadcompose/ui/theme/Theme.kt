package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = Black900,
    primaryVariant = Black900,
    secondary = Black900,
    background = Black900,
    surface = Black900,
    onPrimary = White,
    onSecondary = Black500,

    )

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = White,
    primaryVariant = White,
    secondary = White,
    background = White,
    surface = White,
    onPrimary = Black900,
    onSecondary = Black500,


    )

@Composable
fun SimpleNotepadComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}