package com.example.teste.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.teste.ui.theme.TesteTheme

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    TesteTheme {
        App()
    }
}

@Composable
fun App() {
    var cor by remember {
        mutableStateOf(Color.White)
    }
    Row(modifier = Modifier
        .fillMaxSize()
        .background(cor),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceAround) {

       MyButton(texto = "Red") {cor = Color.Red}
       MyButton(texto = "Green") {cor = Color.Green}
       MyButton(texto = "Blue") {cor = Color.Blue}

    }
}

@Composable
fun MyButton(texto: String,acao: () -> Unit) {
    Button(onClick = { acao() }) { Text(text = texto) }
}