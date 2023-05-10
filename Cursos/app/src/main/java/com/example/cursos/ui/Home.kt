package com.example.cursos.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.cursos.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursos.data.Curso
import com.example.cursos.data.ListaDireita
import com.example.cursos.data.ListaEsquerda
import com.example.cursos.ui.theme.CursosTheme

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    App()
}

@Composable
fun App() {
    CursosTheme {
        Row(Modifier.fillMaxSize()){
              coluna(direcao = true, largura = .5f)
              coluna(direcao = false, largura = 1f)
        }
    }
}

@Composable
fun coluna(direcao: Boolean,largura: Float) {
    LazyColumn{
        items(if (direcao)ListaEsquerda else ListaDireita){
            MyCard(curso = it, largura = largura)
        }
    }
}

@Composable
fun MyCard(curso: Curso, largura: Float) {
    val qtd = (1 .. 300).random()
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth(largura)
            .padding(8.dp)

    ) {
        Row{

            Image(painter = painterResource(id = curso.imagem),
                contentDescription = stringResource(id = curso.titulo),
            modifier = Modifier
                .size(68.dp))

            Spacer(modifier = Modifier.width(16.dp))

            Column {

                Text(text = stringResource(id = curso.titulo),
                style = MaterialTheme.typography.body2)
                Row{
                    Icon(painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                    tint = Color.Black)
                    Text(text = "$qtd")
                }
            }
        }
    }
}