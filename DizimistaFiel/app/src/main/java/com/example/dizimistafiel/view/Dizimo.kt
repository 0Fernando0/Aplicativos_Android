package com.example.dizimistafiel.view

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import com.example.dizimistafiel.R
import com.example.dizimistafiel.ui.customComponent.MyCenterColumn
import com.example.dizimistafiel.ui.customComponent.MyTextField




@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Dizimar(
    navController: NavHostController
) {

        var dizimo by rememberSaveable { mutableStateOf("") }

        MyCenterColumn {
            MyTextField(
                input = dizimo,
                onValueChange = { dizimo = it },
                label = R.string.barra
            )
        }

}

    
