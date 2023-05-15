package com.fernando.pesoideal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fernando.pesoideal.ui.theme.PesoIdealTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PesoIdealTheme {

            }
        }
    }

}
