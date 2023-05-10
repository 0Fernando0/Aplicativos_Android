package com.example.calculadora

sealed class CalculatorOperator(val symbol: String) {
    object Add: CalculatorOperator("+")
    object Subtract: CalculatorOperator("-")
    object Multiply: CalculatorOperator("x")
    object Divide: CalculatorOperator("/")
}
