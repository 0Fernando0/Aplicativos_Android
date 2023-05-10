package com.example.textselection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.example.textselection.ui.theme.TextSelectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextSelectionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun CustomText() {
    // permite criar um texto selecionavel ( permite copiar e colar)
    SelectionContainer {
        Column {
            Text(text = "Olá, Meu Amigo")
            Text(text = "Não Fique Triste")
            Text(text = "Deus Tem O Melhor")
            Text(text = "Para Sua Vida")
            Text(text = "Apenas... Continue")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextSelectionTheme {
        CustomText()
    }
}