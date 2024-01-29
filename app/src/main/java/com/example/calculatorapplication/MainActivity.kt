package com.example.calculatorapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculatorapplication.ui.theme.CalculatorApplicationTheme
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorApplicationTheme {
 val viewModel: CalculatorViewModel by viewModels()
               val state = viewModel.state
                val buttonSpacing = 8.dp
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.spacedBy(buttonSpacing),
                    ) {
                        Text(
                            text = state.firstNumber.toString()+ (state.operation?.symbol ?: "") + state.secondNumber.toString(),
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 32.dp),
                            fontWeight = FontWeight.Light,
                            fontSize = 80.sp,
                            color = Color.Black,
                            maxLines = 2
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                          NormalCalculatorButton(
                                symbol = "AC",

                                modifier = Modifier
                                    .aspectRatio(2f)
                                    .weight(2f).background(color = Color.LightGray)
                            ) {
                                viewModel.onAction(CalculatorAction.Clear)
                            }
                            NormalCalculatorButton(
                                symbol = "Del",

                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f).background(color = Color.LightGray)
                            ) {
                                viewModel.onAction(CalculatorAction.Delete)
                            }
                            NormalCalculatorButton(
                                symbol = "/",

                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f).background(color = Color.Green)
                            ) {
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            NormalCalculatorButton(
                                symbol = "7",

                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f).background(color = Color.Black)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(7))
                            }
                            NormalCalculatorButton(
                                symbol = "8",

                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f).background(color = Color.Black)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(8))
                            }
                            NormalCalculatorButton(
                                symbol = "9",

                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f).background(color = Color.Black)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(9))
                            }
                            NormalCalculatorButton(
                                symbol = "x",

                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f).background(color = Color.Green)
                            ) {
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            NormalCalculatorButton(
                                symbol = "4",

                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f).background(color = Color.Black)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(4))
                            }
                            NormalCalculatorButton(
                                symbol = "5",

                                modifier = Modifier
                                    .aspectRatio(1f).background(color = Color.Black)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(5))
                            }
                            NormalCalculatorButton(
                                symbol = "6",

                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f).background(color = Color.Black)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(6))
                            }
                            NormalCalculatorButton(
                                symbol = "-",
                                    modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f).background(color = Color.Green)
                            ) {
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            NormalCalculatorButton(
                                symbol = "1",

                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f).background(color = Color.Black)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(1))
                            }
                            NormalCalculatorButton(
                                symbol = "2",

                                modifier = Modifier
                                    .aspectRatio(1f).background(color = Color.Black)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(2))
                            }
                            NormalCalculatorButton(
                                symbol = "3",

                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f).background(color = Color.Black)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(3))
                            }
                            NormalCalculatorButton(
                                symbol = "+",

                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f).background(color = Color.Green)
                            ) {
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            NormalCalculatorButton(
                                symbol = "0",

                                modifier = Modifier
                                    .aspectRatio(2f)
                                    .weight(2f).background(color = Color.Black)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(0))
                            }
                            NormalCalculatorButton(
                                symbol = ".",

                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f).background(color = Color.Black)
                            ) {
                                viewModel.onAction(CalculatorAction.Decimal)
                            }
                            NormalCalculatorButton(
                                symbol = "=",

                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f).background(color = Color.Green)
                            ) {
                                viewModel.onAction(CalculatorAction.Calculate)
                            }
                        }
                    }
                }
            }
            }

        }
    }




