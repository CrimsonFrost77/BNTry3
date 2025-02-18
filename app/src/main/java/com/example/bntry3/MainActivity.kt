package com.example.bntry3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bntry3.ui.theme.BNTry3Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BNTry3Theme {
                BiggerNumberGame()
            }
        }
    }
}

@Composable
fun BiggerNumberGame() {
    // State variables
    var num1 by remember { mutableStateOf(Random.nextInt(1, 100)) }
    var num2 by remember { mutableStateOf(Random.nextInt(1, 100)) }
    var message by remember { mutableStateOf("Choose the bigger number") }

    // Function to check the answer
    fun checkAnswer(selected: Int) {
        message = if (selected == maxOf(num1, num2)) {
            "Correct!"
        } else {
            "Wrong!"
        }
        // Generate new numbers after answer
        num1 = Random.nextInt(1, 100)
        num2 = Random.nextInt(1, 100)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Bigger Number Game!", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = message, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { checkAnswer(num1) }) {
                Text(text = "$num1")
            }

            Button(onClick = { checkAnswer(num2) }) {
                Text(text = "$num2")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BiggerNumberGamePreview() {
    BNTry3Theme {
        BiggerNumberGame()
    }
}
