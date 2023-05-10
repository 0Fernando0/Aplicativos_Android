package com.example.dizimistafiel.view

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dizimistafiel.R
import com.example.dizimistafiel.ui.customComponent.*
import java.text.NumberFormat


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Calculadora(
    navController: NavHostController
){

        var entradaInput by rememberSaveable { mutableStateOf("") }

        MyCenterColumn {
            MyText(text = R.string.app_name, args = null, 32.sp)
            MyTextField(
                input = entradaInput,
                onValueChange = { entradaInput = it },
                label = R.string.barra
            )
            MyText(text = R.string.saida, args = calculardizimo(entradaInput))
        }

}


private fun calculardizimo(valor : String) : String {
    val valorNumber = valor.toDoubleOrNull() ?: 0.0
    val resultado = (valorNumber/100) * 10
    return NumberFormat.getCurrencyInstance().format(resultado)
}
