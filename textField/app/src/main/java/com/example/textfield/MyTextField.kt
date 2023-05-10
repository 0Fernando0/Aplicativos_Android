package com.example.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.textfield.ui.theme.TextFieldTheme


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextFieldTheme {
        MyTextField()
    }
}


@Composable
fun MyTextField() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Entrada_1()
        Spacer(modifier = Modifier.height(10.dp))
        Entrada_2()
        Spacer(modifier = Modifier.height(10.dp))
        Entrada_3()
    }
}

@Composable
fun Entrada_1() {
    var texto by remember {
        mutableStateOf("")
    }
    MyRow {

        OutlinedTextField(
            value = texto,
            onValueChange = { it -> texto = it }, // expressão lambda
            label = { Text(text = "Name") },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                }
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Close,
                        contentDescription = null)
                }
            }
        )
    }
}

@Composable
fun Entrada_2(){
    var texto by remember {
        mutableStateOf("")
    }
    MyRow {

        TextField(
            value = texto,
            onValueChange = { it -> texto = it }, // expressão lambda
            label = { Text(text = "Name") },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
                }
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Close,
                        contentDescription = null)
                }
            }
        )
    }
}

@Composable
fun Entrada_3(){
    var texto by remember {
        mutableStateOf("")
    }
    MyRow {
        BasicTextField(value = texto,
            onValueChange = {it -> texto = it}
            )
    }
}


@Composable
fun MyRow(content: @Composable () -> Unit){
    Row(Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center){
        content()
    }
}
