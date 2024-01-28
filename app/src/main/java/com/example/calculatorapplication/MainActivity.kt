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
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorApplicationTheme {
 val viewModel: CalculatorViewModel by viewModels()
               val state = viewModel.state
                val buttonSpacing = 8.dp
Calculator(state = state, onAction = viewModel::onAction,
    buttonSpacing = buttonSpacing,
    modifier = Modifier.fillMaxSize().background(color = Color.Black).padding(16.dp))
            }
        }
    }


}

