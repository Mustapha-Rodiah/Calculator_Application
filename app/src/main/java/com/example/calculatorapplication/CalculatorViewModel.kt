package com.example.calculatorapplication

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
    private set
    fun onAction(action: CalculatorAction){
        when(action){
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()

            is CalculatorAction.Clear -> state = CalculatorState()

            is CalculatorAction.Operation -> enterOperation(action.operation)

            is CalculatorAction.Calculate -> performCalculation()

            is CalculatorAction.Delete -> delete()

        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.firstNumber.isNotEmpty() && state.operation == null) {
            state = state.copy(operation = operation)
            return
        }

        if (state.firstNumber.isNotBlank() && state.operation != null && state.secondNumber.isNotBlank()) {
            performCalculation()
        }

        if (operation == CalculatorOperation.Equals) {
            // Clear the operation after performing the calculation
            state = state.copy(operation = null)
        } else {
            // Set the current operation
            state = state.copy(operation = operation)
        }
    }





    private fun enterDecimal(){
if(state.firstNumber.isBlank() && state.operation == null && !state.firstNumber.contains(".")){
     state = state.copy(
         firstNumber = state.firstNumber + "0."
     )
    return
}
        if(state.firstNumber.isNotBlank() && state.operation == null && !state.firstNumber.contains(".")){
            state = state.copy(
                firstNumber = state.firstNumber + "."
            )
            return
        }
        if(state.secondNumber.isBlank() && !state.secondNumber.contains(".")){
            state = state.copy(
               secondNumber = state.secondNumber+ "0."
            )
            return
        }
        if(state.secondNumber.isNotBlank() && !state.secondNumber.contains(".")){
            state = state.copy(
              secondNumber = state.secondNumber + "."
            )

        }

    }

    private fun delete(){
        when {
            state.secondNumber.isNotBlank() -> state = state.copy(
                secondNumber = state.secondNumber.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.firstNumber.isNotBlank() -> state = state.copy(
                firstNumber = state.firstNumber.dropLast(1)
            )
        }
    }
    private fun performCalculation(){
val firstNumber = state.firstNumber.toDoubleOrNull()
        val secondNumber = state.secondNumber.toDoubleOrNull()
        if(firstNumber != null && secondNumber != null){
            val result = when (state.operation){
                is CalculatorOperation.Add -> firstNumber + secondNumber
                is CalculatorOperation.Subtract -> firstNumber - secondNumber
                is CalculatorOperation.Multiply -> firstNumber * secondNumber
                is CalculatorOperation.Divide -> firstNumber / secondNumber

                else -> {}
            }
            state = state.copy(
                firstNumber = result.toString().take(15),
                secondNumber = "",
                operation = null
            )
        }

    }
    private fun enterNumber(number: Int) {
        if(state.operation == null ){
            if(state.firstNumber.length >= MAX_NUM_LENGTH)
            {
                return
            }
            state = state.copy(
                firstNumber = state.firstNumber + number
            )
            return
        }
        if(state.secondNumber.length >= MAX_NUM_LENGTH){
            return
        }
         state = state.copy(
             secondNumber = state.secondNumber + number
         )
    }
    companion object{
        private const val MAX_NUM_LENGTH = 8
    }
}
