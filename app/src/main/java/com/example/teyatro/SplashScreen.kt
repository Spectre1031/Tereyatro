package com.example.teyatro.navigation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import androidx.compose.material3.Text

@Composable
fun SplashNavigation() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreenContent(navController = navController)
        }
        composable("main") {
            HomePage(
                onNavigateToMovieDetails = { /* TODO: implement navigation */ }
            )
        }
    }
}

@Composable
fun SplashScreenContent(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(3000) // 3 seconds delay
        navController.navigate("main") // Navigate to the main screen
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "PRODUCED BY",
            fontSize = 16.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(20.dp)
                .background(Color.Gray)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Canvas(modifier = Modifier.size(200.dp)) {
            drawRect(
                color = Color.Black,
                style = Stroke(width = 2.dp.toPx())
            )
            drawLine(
                color = Color.Black,
                start = Offset(0f, 0f),
                end = Offset(size.width, size.height),
                strokeWidth = 2.dp.toPx()
            )
            drawLine(
                color = Color.Black,
                start = Offset(size.width, 0f),
                end = Offset(0f, size.height),
                strokeWidth = 2.dp.toPx()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "TEYATRO",
            fontSize = 24.sp,
            color = Color.Black
        )
        Text(
            text = "Lorem ipsum dolor sit amet",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}