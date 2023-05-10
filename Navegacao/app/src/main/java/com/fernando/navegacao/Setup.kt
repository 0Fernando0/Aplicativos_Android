package com.fernando.navegacao

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fernando.navegacao.view.DetailScreen
import com.fernando.navegacao.view.HomeScreen

@Composable
fun Setup(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Home.route){

        composable(route = Screen.Home.route){
            HomeScreen(navController)
        }

        composable(route = Screen.Detail.route){
            DetailScreen(navController)
        }

    }
}