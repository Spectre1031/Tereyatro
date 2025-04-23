package com.example.teyatro.navigation
import com.example.teyatro.navigation.Screen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Search : Screen("search")
    object Watchlist : Screen("watchlist")
    object MovieDetails : Screen("movieDetails")
    object Language : Screen("language")
}