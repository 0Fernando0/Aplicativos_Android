package com.example.woof.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = TemaEscuro.primary,
    secondary = TemaEscuro.secondary,
    onSurface = TemaEscuro.onSurface,
    background = TemaEscuro.background,
    onPrimary = TemaEscuro.onPrimary,
    surface = TemaEscuro.surface
)

private val LightColorPalette = lightColors(
    primary = TemaClaro.primary,
    secondary = TemaClaro.secundary,
    surface = TemaClaro.surface,
    background = TemaClaro.background,
    onPrimary = TemaClaro.onPrimary,
    onSurface = TemaClaro.onSurface
)

@Composable
fun WoofTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )

}