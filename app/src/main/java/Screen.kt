package com.example.teyatro.navigation

import com.example.teyatro.navigation.Screen

public sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Search : Screen("search")
    object Watchlist : Screen("watchlist")
    object MovieDetails : Screen("movieDetails")
    object Language : Screen("language")
}