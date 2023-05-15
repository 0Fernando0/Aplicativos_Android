package com.fernando.controleremoto.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fernando.controleremoto.viewmodel.Tv

@Preview
@Composable
fun Teste() {
    RemoteControlApp()
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RemoteControlApp() {
    var volume by remember { mutableStateOf(0) }
    var channel by remember { mutableStateOf(1) }

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Controle Remoto") }) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { Tv.sendCommandToTV("CH-") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Canal Anterior")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { 
                              Tv.sendCommandToTV("CH+")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Próximo Canal")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Canal: $channel")
            }
        }
    )
}