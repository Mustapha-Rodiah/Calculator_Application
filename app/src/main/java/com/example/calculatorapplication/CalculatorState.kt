package com.example.calculatorapplication

data class CalculatorState (
    val firstNumber: String = "",
    val secondNumber: String = "",
    val operation: CalculatorOperation? = null
)