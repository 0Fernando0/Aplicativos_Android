package com.example.mycomposable

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycomposable.ui.theme.MyComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    Column {
        var myValue: Boolean by remember { mutableStateOf(false) }
        Log.d("Recomposicao", "Lembrei Da Variavel")
        var texto: String = if (myValue) "Verdadeiro" else "Falso"
        Button(onClick = { myValue = !myValue }) {
            Text(text = texto)
            Log.d("Recomposicao", "Butão Content Lambda")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposableTheme {
        App()
    }
}