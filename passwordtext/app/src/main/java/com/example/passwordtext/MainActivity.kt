package com.example.passwordtext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.passwordtext.ui.theme.Gui
import com.example.passwordtext.ui.theme.PasswordTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordTextTheme {
                Gui()
            }
        }
    }
}
