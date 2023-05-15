package com.fernando.pesoideal.viewmodel

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.fernando.pesoideal.componentes.MyText

@Composable
fun Mensagem(
    nivel: Niveis
) {
    when(nivel){
        Niveis.ABAIXO -> MyText(text = "Abaixo Do Peso", Color.Green)
        Niveis.IDEAL -> MyText(text = "Peso Ideal", Color.Green)
        Niveis.SOBREPESO -> MyText(text = "Sobrepeso", Color.Yellow)
        Niveis.OBESIDADE -> MyText(text = "Obesidade", Color.Red)
        Niveis.MORBIDA -> MyText(text = "Obesidade Morbida", Color.Black)
        else -> Text(text = "")
    }
}

fun calcularImc(
    peso: String,
    altura: String,
): Niveis {
    val numberPeso = peso.toDoubleOrNull() ?: 0.0
    val numberAltura = altura.toDoubleOrNull() ?: 0.0

    if(numberAltura == 0.0 || numberPeso == 0.0) return Niveis.nulo

    val imc: Double = numberPeso / (numberAltura * numberAltura)

    return when (imc) {
        in (1.0..18.4) -> Niveis.ABAIXO
        in (18.5..25.0) -> Niveis.IDEAL
        in (25.0..30.0) -> Niveis.SOBREPESO
        in (35.0..40.0) -> Niveis.OBESIDADE
        else -> Niveis.MORBIDA
    }
}