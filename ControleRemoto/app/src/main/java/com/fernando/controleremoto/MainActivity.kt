package com.fernando.controleremoto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fernando.controleremoto.ui.theme.ControleRemotoTheme
import com.fernando.controleremoto.view.RemoteControlApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ControleRemotoTheme {
                RemoteControlApp()
            }
        }
    }
}
