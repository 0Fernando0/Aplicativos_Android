package com.example.firstcomposable

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcomposable.ui.theme.FirstComposableTheme

const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"criando...")
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    FirstComposableTheme{
        Column(
            modifier = Modifier.fillMaxSize(1f),
            verticalArrangement = Arrangement.SpaceAround, // eixo y
            horizontalAlignment = Alignment.CenterHorizontally // eixo x
        ) {
            MySurface(msg = "Hello",5f,0xff22aa56)
            MySurface(msg = "Hello",1f,0xff6543ff)

        }
    }
}

@Composable
fun ColumnScope.MySurface(msg: String,tam: Float = 1f, cor: Long) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .weight(tam)
        ,
        color = Color(cor)
    ) { Text(text = msg) }
}

