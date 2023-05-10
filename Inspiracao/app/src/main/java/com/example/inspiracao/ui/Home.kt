package com.example.inspiracao.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.inspiracao.data.Afimacao
import com.example.inspiracao.data.ListaAfirmacao
import com.example.inspiracao.ui.theme.InspiracaoTheme

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    App()
}

@Composable
fun App() {
    InspiracaoTheme {
        MeusCards()
    }
}

@Composable
fun MeuCard(card: Afimacao) {
    Card(
        modifier = Modifier
            .padding(8.dp),
        elevation = 4.dp
        ) {
        Column{
            Image(painter = painterResource(id = card.imagem),
                contentDescription = stringResource(id = card.titulo),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
            )
            Text(text = stringResource(id = card.titulo),
            modifier = Modifier
                .padding(16.dp),
            style = MaterialTheme.typography.h6)
        }
    }
}

@Composable
fun MeusCards() {
    LazyColumn{
        items(ListaAfirmacao){
            MeuCard(card = it)
        }
    }
}