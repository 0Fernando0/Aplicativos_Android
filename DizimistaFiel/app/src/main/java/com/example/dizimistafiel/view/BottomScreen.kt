package com.example.dizimistafiel.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNav(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottonBarScreen.CalculadoraButton.route
    ) {

        composable(route = BottonBarScreen.CalculadoraButton.route) {
            Calculadora(navController)
        }

        composable(route = BottonBarScreen.DizimarButton.route) {
            Dizimar(navController)
        }

    }
}