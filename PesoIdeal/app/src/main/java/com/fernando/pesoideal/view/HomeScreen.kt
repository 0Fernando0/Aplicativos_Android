package com.fernando.pesoideal.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fernando.pesoideal.componentes.MyTextField
import com.fernando.pesoideal.viewmodel.Mensagem
import com.fernando.pesoideal.viewmodel.Niveis
import com.fernando.pesoideal.viewmodel.calcularImc

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenpreview() {
    HomeScreen()
}

@Composable
fun HomeScreen() {

    var status by remember { mutableStateOf(Niveis.nulo) }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize(),
    contentAlignment = Alignment.Center)
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Mensagem(nivel = status)

            MyTextField(value = peso,
                onValueChange = {peso = it},
                label = "Peso (Kg)",
                placeholder = "Qual é seu Peso?")

            MyTextField(value = altura,
                onValueChange = {altura = it},
                label = "Altura (m)",
                placeholder = "Qual é a Altura?")

            Button(onClick = {
                status = calcularImc(peso,altura)
            }) {
                Text(text = "Calcular")
            }

        }
    }
}
