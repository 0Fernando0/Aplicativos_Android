package com.example.dizimistafiel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dizimistafiel.ui.theme.DizimistaFielTheme
import com.example.dizimistafiel.view.MainScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DizimistaFielTheme {
                MainScreen()
            }
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Teste() {
    MainScreen()
}

