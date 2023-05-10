package com.example.cartaoaniversario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartaoaniversario.ui.theme.CartaoAniversarioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartaoAniversarioTheme {
                App(aniversariante = "Kaio", emissor = "Anderson")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewApp() {
    CartaoAniversarioTheme {
        App(aniversariante = "Kaio", emissor = "Anderson")
    }
}

@Composable
fun App(aniversariante: String, emissor: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Image(painter = painterResource(id = R.drawable.androidparty),
            contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize())
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)

        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.aniversariante,aniversariante),
            fontSize = 28.sp,
            modifier = Modifier
                .align(CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(R.string.emissor,emissor),
                fontSize = 22.sp,
                modifier = Modifier
                    .align(End)
            )
        }
    }
}