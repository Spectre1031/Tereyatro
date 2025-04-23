package com.example.teyatro.navigation

import SearchScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teyatro.navigation.HomePage
import com.example.teyatro.R


sealed class Screens(val route: String) {
    object Home : Screen("home")
    object Search : Screen("search")
    object Watchlist : Screen("watchlist")
    object MovieDetails : Screen("movieDetails")
    object Language : Screen("language")
}
@Composable
public fun AppNavigations() {
    val navController = rememberNavController()

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
            MoviePosterWithInfo(
                posterRes = R.drawable.filler_image,
                onMovieClick = { navController.popBackStack() }
            )
        }
        composable(Screen.Language.route) {

            navController.popBackStack()
        }
    }
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
            MoviePosterWithInfo(
                posterRes = R.drawable.filler_image,
                onMovieClick = { navController.popBackStack() }
            )
        }
        composable(Screen.Language.route) {
            navController.popBackStack()
        }
    }
}