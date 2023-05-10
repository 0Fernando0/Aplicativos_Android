package com.example.calculatetip.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.calculatetip.R
import com.example.calculatetip.ui.theme.CalculateTipTheme
import java.text.NumberFormat
import kotlin.math.round

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewApp() {
    CalculateTipTheme{
        App()
    }
}

@Composable
fun App() {

    var valor by remember { mutableStateOf("") }
    var porcentagem by remember { mutableStateOf("") }
    var status by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomText(texto = R.string.app_name,
            fontSize = 26,
            fontWeight = FontWeight.Normal
        )
        CustomTextField(placehold = R.string.label1, input = valor, funcao = {valor = it })
        CustomTextField(placehold = R.string.label2, input = porcentagem, funcao = { porcentagem = it })
        MyRow(status = status, funcao = { status = !status })
        CustomText(texto = R.string.resultado,
            args = calcular(valor,porcentagem,status),
            fontSize = 16,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun CustomText(
    @StringRes texto: Int,
    args: String? = null,
    fontSize: Int,
    fontWeight: FontWeight
) {
    val text = if(args != null) stringResource(id = texto,args) else stringResource(id = texto)
    Text(
        text = text,
        fontSize = fontSize.sp,
        fontWeight = fontWeight
    )
}

@Composable
fun CustomTextField(
    @StringRes placehold: Int,
    input: String,
    funcao: (String) -> Unit
) {
    TextField(value = input,
        onValueChange = funcao,
        placeholder = { Text(text = stringResource(id = placehold)) },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun MyRow(status: Boolean, funcao: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomText(texto = R.string.label3,
            fontSize = 16,
            fontWeight = FontWeight.Bold)
        Switch(checked = status, onCheckedChange = funcao)
    }
}

private fun calcular(valor: String, porc: String,status: Boolean): String {
    val valorNumerico = valor.toDoubleOrNull() ?: 0.0
    val porcNumerico = porc.toDoubleOrNull() ?: 0.0
    val resultado = if(status) round ((valorNumerico/100) * porcNumerico) else (valorNumerico/100) * porcNumerico
    return NumberFormat.getCurrencyInstance().format(resultado)
}