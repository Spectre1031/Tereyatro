package com.example.teyatro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teyatro.screens.SearchScreen
import com.example.teyatro.screens.WatchlistScreen
import com.example.teyatro.screens.MovieDetailsScreen
import com.example.teyatro.screens.HomePage

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Search : Screen("search")
    object Watchlist : Screen("watchlist")
    object MovieDetails : Screen("movieDetails")
    object Language : Screen("language")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavGraph(navController = navController)
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomePage(
                onNavigateToSearch = { navController.navigate(Screen.Search.route) },
                onNavigateToWatchlist = { navController.navigate(Screen.Watchlist.route) },
                onNavigateToMovieDetails = { navController.navigate(Screen.MovieDetails.route) }
            )
        }
        composable(Screen.Search.route) {
            SearchScreen(
                onBackClick = { navController.popBackStack() },
                onNavigateToMovieDetails = { navController.navigate(Screen.MovieDetails.route) }
            )
        }
        composable(Screen.Watchlist.route) {
            WatchlistScreen(
                onBackClick = { navController.popBackStack() },
                onNavigateToMovieDetails = { navController.navigate(Screen.MovieDetails.route) }
            )
        }
        composable(Screen.MovieDetails.route) {
            MovieDetailsScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(Screen.Language.route) {
            navController.popBackStack()
        }
    }
}