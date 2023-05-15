package com.fernando.mycontatos.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fernando.mycontatos.model.DataBase

@Preview(showBackground = true)
@Composable
fun Teste() {
    val context = LocalContext.current
    val database = DataBase(context)
    HomeScreen(database)
}

@Composable
fun HomeScreen(
    dataBase: DataBase
) {
    var nome by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)){

        Column{

            CustomRow {
                TextField(value = nome,
                    onValueChange = { nome = it })
                Button(onClick = {
                    dataBase.inserir(nome)
                }) {
                    Text(text = "ADD")
                }
            }

            dataBase.visualizarDados().forEach{
                Text(text = it)
            }

        }

    }
}

@Composable
fun CustomRow(content: @Composable () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
       verticalAlignment = Alignment.CenterVertically

    ) {
        content()
    }
}