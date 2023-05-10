package com.example.barra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barra.ui.theme.BarraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaTest() {
    var nivel by remember {
        mutableStateOf(.0f)
    }
    BarraTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            MyRow(nivel)
            CustemRow({ if(nivel != 0f) nivel -= .2f }) { if(nivel != 1f) nivel += .2f}
        }



    }
}

@Composable
fun MyRow(load: Float) {
    Row(modifier = Modifier
        .fillMaxWidth(),
    horizontalArrangement = Arrangement.Center) {
        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(.8f)
                .height(30.dp)
                .padding(4.dp)

        ){
            Box(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxWidth(load)
                    .height(30.dp)
            )
            Text(text = "Carregando...", modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
            )

        }
    }
}

@Composable
fun CustemRow(decremento: () -> Unit, incremento: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(onClick = { decremento() }) {
            Text(text = "-")
        }
        Button(onClick = { incremento() }) {
            Text(text = "+")
        }
    }
}