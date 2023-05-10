package com.example.grandientbutton

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grandientbutton.ui.theme.GrandientButtonTheme

@Preview(showBackground = true)
@Composable
fun GrandienteApp() {
    Column(Modifier.fillMaxSize()) {


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
            ) {}
        }
    }
}

@Composable
fun GrandienteBotao(
    text: String,
    textColor: Color,
    grandient: Brush,
    onClick: () -> Unit
){
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        contentPadding = PaddingValues(),
        onClick = { onClick() }
    ) {

        Box(
            modifier = Modifier
                .background(grandient)
                .padding(horizontal = 16.dp, vertical = 8.dp)
            ,
            contentAlignment = Alignment.Center
        ){
            Text(text = text, color = textColor)
        }
        
    }
}