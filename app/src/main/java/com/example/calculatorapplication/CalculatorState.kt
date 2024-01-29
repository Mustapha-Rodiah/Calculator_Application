package com.example.calculatorapplication

data class CalculatorState (
    var firstNumber: String = "",
    val secondNumber: String = "",
    val operation: CalculatorOperation? = null
)