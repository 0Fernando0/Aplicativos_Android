package com.example.game.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.game.ui.theme.GameTheme

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    GameTheme {
        Layout()
    }
}

@Composable
fun Layout() {
    val certo = remember {
        (1..100).random()
    }

    var tentativas by remember {
        mutableStateOf(1)
    }
    var input by remember {
        mutableStateOf("")
    }
    var alerta by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Adivinhe O Número Entre 1 A 100")
        Text(text = "Tentaiva: $tentativas")
        Text(text = alerta)

        MyField(entrada = input) {
            if (it.matches(Regex("\\d*"))) {
                input = it
            }
        }

        MyButton(texto = "Tentar") {
            if(input.isNotBlank()){
                alerta = when(input.toInt()){
                    in (1..100) -> {
                        tentativas++
                        when{
                            input.toInt() > certo -> "Menos..."
                            input.toInt() < certo -> "Mais..."
                            else -> "VOCÊ GANHOU!, EU PENSEI NO $certo"
                        }
                    }
                    else -> "SÓ NÚMEROS ENTRE 1 A 100"
                }
            }
        }
    }
}

@Composable
fun MyField(
    entrada: String,
    funcao: (String) -> Unit
) {
    TextField(
            value = entrada,
            onValueChange = funcao,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
}

@Composable
fun MyButton(texto: String, acao: () -> Unit) {
    Button(
        onClick = { acao() }
    ) {
        Text(text = texto)
    }
}
