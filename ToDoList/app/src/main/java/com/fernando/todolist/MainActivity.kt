package com.fernando.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fernando.todolist.ui.theme.ToDoListTheme
import com.fernando.todolist.view.NavScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListTheme {

                NavScreen()

            }
        }
    }
}
