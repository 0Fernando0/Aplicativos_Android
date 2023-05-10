package com.example.appum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appum.ui.theme.AppUmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppUmTheme {
                MyComposable()
            }
        }
    }
}

@Composable
fun MyComposable() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var name by remember { mutableStateOf("") }
        val maxChar = 10

        OutlinedTextField(
            value = name,
            onValueChange = {
                if(name.length < maxChar){
                    name = it
                }
            },
            label = { Text(text = "Nome") },
            placeholder = { Text(text = "Digite Seu Nome") },
            maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Test() {
    AppUmTheme {
        MyComposable()
    }
}

