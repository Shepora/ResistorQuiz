package com.example.resistencequiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import com.example.resistencequiz.ui.theme.ColorCodeCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorCodeCalculatorTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ResistanceCalScreen()
                }
            }
        }
    }
}