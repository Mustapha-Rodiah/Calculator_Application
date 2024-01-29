package com.example.calculatorapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Box



import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
 fun NormalCalculatorButton(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit


    ){
  Box (contentAlignment = Alignment.Center,
      modifier = Modifier
          .clip(CircleShape)
          .clickable { onClick() }
          .then(modifier)){
      Text(text = symbol,
          fontSize = 36.sp,
          color = MaterialTheme.colorScheme.onSecondary)


  }
 }
@Composable
fun SpanCalculatorButton(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit


){
    Box (contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .then(modifier)){
        Text(text = symbol,
            fontSize = 16.sp,
            color = Color.White)


    }
}

@Composable
@Preview
fun SpanPreview(){
    SpanCalculatorButton(symbol = "Ac", modifier = Modifier.background(color = Color.Green) ) {

    }
}