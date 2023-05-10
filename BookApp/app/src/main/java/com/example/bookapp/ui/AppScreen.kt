package com.example.bookapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookapp.ui.theme.BookAppTheme

@Preview(showBackground = true)
@Composable
fun Test() {
    BookAppTheme {
        LayoutScreen()
    }
}

@Composable
fun LayoutScreen() {
    var valor by remember {
        mutableStateOf(0)
    }
    Column(Modifier
        .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        Text(text = valor.toString())

        Button(onClick = { valor++ }) {
            Text(text = "Click Em Mim")
        }
    }

}
