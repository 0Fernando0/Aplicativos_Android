package com.fernando.mycontatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.fernando.mycontatos.model.DataBase
import com.fernando.mycontatos.ui.theme.MyContatosTheme
import com.fernando.mycontatos.view.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyContatosTheme {
                val database = DataBase(LocalContext.current)
                HomeScreen(dataBase = database)
            }
        }
    }
}
