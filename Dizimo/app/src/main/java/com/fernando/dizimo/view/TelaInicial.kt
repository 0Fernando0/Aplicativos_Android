package com.fernando.dizimo.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun TelaTeste() {
    TelaInicial()
}

@Composable
fun TelaInicial(
    grandient: List<Color>? = null,
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier
        .fillMaxSize()
        .background(
            Brush.verticalGradient(
                grandient?: listOf(
                    Color.White,
                    Color.White
                )
            )
        ),
    contentAlignment = Alignment.Center){

    }

}