package com.example.calculatorapplication

import android.widget.GridLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculator(state: CalculatorState,
               onAction : (CalculatorAction)-> Unit,
               modifier: Modifier = Modifier,
               buttonSpacing: Dp = 8.dp){

    Box(modifier = modifier.fillMaxSize().background(color = Color.White).padding(16.dp)
        ){
        Column (modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing),)
        {
Text(text = state.firstNumber + state.operation ?.symbol?: "" + state.secondNumber,
    textAlign = TextAlign.End,
    fontSize = 80.sp,
    color= Color.White,
    modifier = Modifier
        .padding(vertical = 32.dp)
        .fillMaxWidth(),
    fontWeight = FontWeight.Light,
    maxLines = 2
)
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)){
          SpanCalculatorButton(symbol = "AC", modifier = Modifier
              .weight(2f)
              .background(color = Color.LightGray)
              .aspectRatio(1f),
          onClick = {
              onAction(CalculatorAction.Clear)
          }
          )
          NormalCalculatorButton(symbol = "Del", modifier = Modifier
              .weight(1f)
              .background(color = Color.LightGray)
              .aspectRatio(2f),
                onClick = {
                    onAction(CalculatorAction.Delete)
                }
            )
        NormalCalculatorButton(symbol = "/", modifier = Modifier
            .weight(2f)
            .background(color = Color.Yellow)
            .aspectRatio(2f),
                onClick = {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                }
            )

        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)){
            NormalCalculatorButton(symbol = "7", modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = Color.DarkGray),
                onClick = {
                    onAction(CalculatorAction.Number(7))
                }
            )
            NormalCalculatorButton(symbol = "8", modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = Color.DarkGray),
                onClick = {
                    onAction(CalculatorAction.Number(8))
                }
            )
            NormalCalculatorButton(symbol = "9", modifier = Modifier
                .weight(1f)
                .background(color = Color.DarkGray)
                .aspectRatio(1f),
                onClick = {
                    onAction(CalculatorAction.Number(9))
                }
            )
            NormalCalculatorButton(symbol = "x", modifier = Modifier
                .weight(1f)
                .background(color = Color.Yellow)
                .aspectRatio(1f),
                onClick = {onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                }
            )
        }


        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)){
            NormalCalculatorButton(symbol = "4", modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = Color.DarkGray),
                onClick = {
                    onAction(CalculatorAction.Number(4))
                }
            )
            NormalCalculatorButton(symbol = "5", modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = Color.DarkGray),
                onClick = {
                    onAction(CalculatorAction.Number(5))
                }
            )
            NormalCalculatorButton(symbol = "6", modifier = Modifier
                .weight(1f)
                .background(color = Color.DarkGray)
                .aspectRatio(1f),
                onClick = {
                    onAction(CalculatorAction.Number(6))
                }
            )
            NormalCalculatorButton(symbol = "-", modifier = Modifier
                .weight(1f)
                .background(color = Color.Yellow)
                .aspectRatio(1f),
                onClick = {onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                }
            )
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)){
            NormalCalculatorButton(symbol = "1", modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = Color.DarkGray),
                onClick = {
                    onAction(CalculatorAction.Number(1))
                }
            )
            NormalCalculatorButton(symbol = "2", modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = Color.DarkGray),
                onClick = {
                    onAction(CalculatorAction.Number(2))
                }
            )
            NormalCalculatorButton(symbol = "3", modifier = Modifier
                .weight(1f)
                .background(color = Color.DarkGray)
                .aspectRatio(1f),
                onClick = {
                    onAction(CalculatorAction.Number(3))
                }
            )
            NormalCalculatorButton(symbol = "=", modifier = Modifier
                .weight(1f)
                .background(color = Color.DarkGray)
                .aspectRatio(1f),
                onClick = {onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                }
            )
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)){
            SpanCalculatorButton(symbol = "0", modifier = Modifier
                .weight(2f)
                .background(color = Color.LightGray)
                .aspectRatio(1f),
                onClick = {
                    onAction(CalculatorAction.Number(0))
                }
            )
            NormalCalculatorButton(symbol = ".", modifier = Modifier
                .weight(1f)
                .background(color = Color.LightGray)
                .aspectRatio(2f),
                onClick = {
                    onAction(CalculatorAction.Decimal)
                }
            )
            NormalCalculatorButton(symbol = "=", modifier = Modifier
                .weight(2f)
                .background(color = Color.Green)
                .aspectRatio(2f),
                onClick = {
                    onAction(CalculatorAction.Calculate)
                }
            )

        }
    }
}
