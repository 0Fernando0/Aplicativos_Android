package com.example.grandientbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.grandientbutton.ui.theme.GrandientButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}


@Composable
fun App() {
    GrandientButtonTheme {
        GrandienteBotao(
            text = "Botão",
            textColor = Color.White,
            grandient = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xff123456),
                    Color(0xff654321)
                )
            )
        ){}
    }
}