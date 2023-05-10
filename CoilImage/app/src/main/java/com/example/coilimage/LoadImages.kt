package com.example.coilimage

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.coilimage.ui.theme.CoilImageTheme

@Composable
fun ImageUrl() {
    Box(
        modifier = Modifier
            .size(150.dp),
        contentAlignment = Alignment.Center
    ) {
        // https://seeklogo.com/images/K/kotlin-logo-6A9E0484CA-seeklogo.com.png
        AsyncImage(
            model = "https://seeklogo.com/images/K/kotlin-logo-6A9E0484CA-seeklogo.com.png",
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CoilImage(){
    CoilImageTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            ImageUrl()
        }
    }
}