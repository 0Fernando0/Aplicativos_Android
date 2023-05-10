package com.example.guessthenumber.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = DarkColors.get("primary")!!,
    primaryVariant = DarkColors.get("primaryVariant")!!,
    secondary = DarkColors.get("secondary")!!,
    background = DarkColors.get("background")!!,
    surface = DarkColors.get("surface")!!,
    onPrimary = DarkColors.get("onPrimary")!!,
    onSecondary = DarkColors.get("onSecondary")!!,
    onBackground = DarkColors.get("onBackground")!!,
    onSurface = DarkColors.get("onSurface")!!,
)


private val LightColorPalette = lightColors(
    primary = LightColors["primary"]!!,
    primaryVariant = LightColors["primaryVariant"]!!,
    secondary = LightColors["secondary"]!!,
    background = LightColors["background"]!!,
    surface = LightColors["surface"]!!,
    onPrimary = LightColors["onPrimary"]!!,
    onSecondary = LightColors["onSecondary"]!!,
    onBackground = LightColors["onBackground"]!!,
    onSurface = LightColors["onSurface"]!!,
)

@Composable
fun GuessTheNumberTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when(darkTheme) {
        true -> DarkColorPalette
        else -> LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}