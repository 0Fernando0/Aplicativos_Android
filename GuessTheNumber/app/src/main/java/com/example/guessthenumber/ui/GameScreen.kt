package com.example.guessthenumber.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guessthenumber.R
import com.example.guessthenumber.ui.theme.GuessTheNumberTheme

/* AQUI FICA O LAYOUT DO GAME */

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GuessTheNumberTheme {
        GameApp()
    }
}

@Composable
fun GameApp() {
    var userInput by remember {
        mutableStateOf("")
    }
    val userNumber = userInput.toIntOrNull() ?: 0
    val res = (1..100).random()
    var ativar by remember {
        mutableStateOf(false)
    }


    Column() {

        Layout_top(userNumber,res,ativar) // selecionar
        Layout_Bottom(usuario = userInput,{userInput = it},{ativar = true}) // modificar
        if (ativar) {
            MensagemCheck(palpite = userNumber, resposta = res, active = true)
        }
    }

}

@Composable
fun Layout_top(palpite : Int , resposta : Int, action: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
            )

        Text(
            text = stringResource(id = R.string.titulo),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        MensagemCheck(palpite = palpite, resposta = resposta, active = action)
    }
}

@Composable
fun Layout_Bottom(usuario: String, funcao : (String) -> Unit, acao : () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Entrada(usuario = usuario, funcao = funcao)
        Button(onClick = {
            acao()
        },
            modifier = Modifier.padding(top = 16.dp)
        )
        {
            Text(text = stringResource(id = R.string.botao))
        }
    }
}

@Composable
fun Entrada(usuario: String, funcao : (String) -> Unit) {
    TextField(
        value = usuario,
        onValueChange = funcao,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
}


@Composable
fun MensagemCheck(palpite: Int,resposta: Int, active: Boolean) {
    if (active) {
        if (palpite > 100) {
            // se for um valor fora do range
            Text(text = stringResource(R.string.erro))
        } else if (palpite in (1..100)) {
            // SE FOR MAIOR QUE O RESULTADO
            if (palpite > resposta) {
                Text(text = stringResource(R.string.maior, palpite))
            }
            // SE FOR MENOR QUE O RESULTADO
            else if (palpite < resposta) {
                Text(text = stringResource(R.string.menor, palpite))
            }
            // QUANDO O PALPITE ACERTA
            else {
                Text(text = stringResource(R.string.certa, resposta))
            }
        }
    }
}