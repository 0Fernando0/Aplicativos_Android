package com.example.limonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.limonada.ui.theme.LimonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadaTheme {
                App()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LimonadaTheme {
        App()
    }
}

@Composable
fun App() {
    var etapas by remember {
        mutableStateOf(1)
    }
    var cliques = (2..4).random()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when(etapas){
            1 -> Imagem(R.string.titulo1,img = R.drawable.lemon_tree) { etapas++ }
            2 -> Imagem(R.string.titulo2,img = R.drawable.lemon_squeeze) {etapas++}
            3 -> Imagem(R.string.titulo3,img = R.drawable.lemon_drink) {
                cliques--
                if (cliques == 0){ etapas++ }
            }
            else -> Imagem(R.string.titulo4,img = R.drawable.lemon_restart) {etapas = 1}
        }
    }
}

@Composable
fun Imagem(@StringRes titulo: Int, @DrawableRes img: Int,funcao: () -> Unit) {
    Text(text = stringResource(titulo))
    Image(
        painter = painterResource(id = img),
        contentDescription = null,
        modifier = Modifier
            .border(color = Color(0xff8EF9F3), width = 2.dp)
            .clickable{ funcao() })
}
