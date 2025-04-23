package com.example.teyatro.navigation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.teyatro.ui.theme.TeyatroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeyatroTheme {
                AppNavigations()
            }
        }
    }
}