package com.fernando.navegacao.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.fernando.navegacao.Screen

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center){
        Text(text = "Home",
        fontSize = 30.sp,
        color = Color.Blue,
        modifier = Modifier
            .clickable {
                navController.navigate(Screen.Detail.route)
            })
    }
}