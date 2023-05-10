package com.example.dizimistafiel.view

import androidx.annotation.DrawableRes
import com.example.dizimistafiel.R

sealed class BottonBarScreen(
    val route: String,
    val label: String,
    @DrawableRes val icon: Int
){
    object CalculadoraButton: BottonBarScreen(
        "calculadora",
        "Calcular",
        R.drawable.percent_48px
    )
    object DizimarButton: BottonBarScreen(
        "dizimo",
        "Dizimar",
        R.drawable.payments_48px
    )
}
