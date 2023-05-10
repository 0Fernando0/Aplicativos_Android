package com.example.adivinhao

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adivinhao.ui.theme.AdivinhaçãoTheme

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    App()
}

@Composable
fun App() {
    val resposta = (1..100).random()
    var tentiva by rememberSaveable {
        mutableStateOf(1)
    }
    var aviso by rememberSaveable {
        mutableStateOf("")
    }
    var userInput by rememberSaveable {
        mutableStateOf("")
    }
    val userNumber = userInput.toIntOrNull() ?: 1


    AdivinhaçãoTheme {
        Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Cima(tentativa = tentiva)
                Meio(texto = aviso)
                Baixo(userInput = userInput, funcao = {userInput = it}) {
                    if (userNumber > 100) {
                        aviso = "[ERROR] SOMENTE NÚMEROS ENTRE 1 ATÉ 100"
                    }
                    else{
                        if(userNumber > resposta){
                            aviso = "ERROU... A RESPOSTA É MENOR"
                            tentiva++
                        }
                        else if(userNumber < resposta){
                            aviso = "ERROU... A RESPOSTA É MAIOR"
                            tentiva++
                        }
                        else{
                            aviso = "VOCÊ ACERTOU! EU PENSEI NO $resposta"
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun Cima(tentativa: Int) {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)

    ) {
        Text(text = "Adivinhe O Número Que Estou Pensando...")
        Text(text = "Dica: de 1 até 100")
        Text(text = stringResource(id = R.string.tentativas,tentativa))

    }
}

@Composable
fun Meio(texto: String) {
    Text(text = texto)
}

@Composable
fun Baixo(userInput: String, funcao : (String) -> Unit,new_value: () -> Unit) {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        TextField(
            value = userInput,
            onValueChange = funcao,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            label = { Text(text = "Seu Palpite") }
        )
        Button(
            onClick = { new_value() }) {
            Text(text = "Tentar")
        }
    }
}
