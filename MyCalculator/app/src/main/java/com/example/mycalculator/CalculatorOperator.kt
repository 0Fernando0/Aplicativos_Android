package com.example.mycalculator

sealed class CalculatorOperator(val symbol: String) {
    object Add: CalculatorOperator("+")
    object Subtract: CalculatorOperator("-")
    object Multiply: CalculatorOperator("x")
    object Divide: CalculatorOperator("/")
}
