package com.example.individualassignment2q1_cyang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import com.example.individualassignment2q1_cyang.ui.theme.IndividualAssignment2Q1_CyangTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndividualAssignment2Q1_CyangTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    MotivationQuoteApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MotivationQuoteApp(modifier: Modifier = Modifier) {
    // List of motivational quotes
    val quotes = listOf(
        "Believe you can and you're halfway there.",
        "Your limitation—it's only your imagination.",
        "Push yourself, because no one else is going to do it for you.",
        "Great things never come from comfort zones.",
        "Dream it. Wish it. Do it."
    )

    // Remember a mutable state to hold the current quote index
    var currentQuoteIndex by remember { mutableStateOf(0) }

    // Composable UI
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the current quote with basic text styling
        Text(
            text = quotes[currentQuoteIndex],
            fontSize = 20.sp, // Basic font size
            color = Color.Black, // Basic text color
            textAlign = TextAlign.Center, // Align text to the center
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Button to change the quote
        Button(onClick = {
            currentQuoteIndex = (currentQuoteIndex + 1) % quotes.size // Cycle through quotes
        }) {
            Text("Change Quote")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MotivationQuoteAppPreview() {
    IndividualAssignment2Q1_CyangTheme {
        MotivationQuoteApp()
    }
}
