package com.example.teyatro.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teyatro.R
import com.example.teyatro.ui.theme.TeyatroTheme
import androidx.compose.ui.layout.ContentScale
import components.BottomNavigationBar
import com.example.teyatro.navigation.Screen
import com.example.teyatro.navigation.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.teyatro.navigation.NavGraph


@Composable
fun WatchlistScreen(
    onBackClick: () -> Unit,
    onNavigateToMovieDetails: () -> Unit
) {
    Scaffold(
        topBar = { WatchlistHeader(onBackClick = onBackClick) },
        bottomBar = {
            BottomNavigationBar(
                currentRoute = Screen.Watchlist.route,
                onNavigate = { route -> /* Handle navigation */ }
            )
        }
    ) { padding ->
        WatchlistGrid(
            padding = padding,
            onMovieClick = onNavigateToMovieDetails
        )
    }
}

@Composable
fun WatchlistHeader(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                modifier = Modifier.size(30.dp),
                tint = Color.Black
            )
        }

        Text(
            text = "NAME'S WATCHLIST!",
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = 18.sp),
            color = Color.Black
        )

        IconButton(onClick = { /* Handle edit */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_edit),
                contentDescription = "Edit",
                modifier = Modifier.size(24.dp),
                tint = Color.Black
            )
        }
    }
}

@Composable
fun WatchlistGrid(padding: PaddingValues, onMovieClick: () -> Unit) {
    val posters = listOf(
        R.drawable.filler_image,
        R.drawable.filler_image,
        R.drawable.filler_image,
        R.drawable.filler_image,
        R.drawable.filler_image,
        R.drawable.filler_image
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (row in posters.chunked(2)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { poster ->
                    MoviePosterWithInfo(
                        posterRes = poster,
                        onMovieClick = onMovieClick
                    )
                }
            }
        }
    }
}

@Composable
fun MoviePosterWithInfo(posterRes: Int, onMovieClick: () -> Unit, ) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onMovieClick),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = MaterialTheme.shapes.medium
    ) {
        Box(
            modifier = Modifier.wrapContentSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier.size(120.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Image(
                        painter = painterResource(id = posterRes),
                        contentDescription = "Movie Poster",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_alert),
                    contentDescription = "Info Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(4.dp)
                )
            }
        }
    }
}

@Composable
fun MovieInfo(

    onMovieClick: () -> Unit,
    onNavigateToMovieDetails: () -> Unit)
{
    Button(onMovieClick) {
        val navController = rememberNavController()
        NavGraph(navController = navController)
    }
}
@Preview(showBackground = true, heightDp = 800)
@Composable
fun WatchlistScreenPreview() {
    TeyatroTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            WatchlistScreen(
                onBackClick = {},
                onNavigateToMovieDetails = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WatchlistHeaderPreview() {
    TeyatroTheme {
        WatchlistHeader(onBackClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun WatchlistGridPreview() {
    TeyatroTheme {
        WatchlistGrid(
            padding = PaddingValues(16.dp),
            onMovieClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoviePosterWithInfoPreview() {
    TeyatroTheme {
        MoviePosterWithInfo(
            posterRes = R.drawable.filler_image,
            onMovieClick = {}
        )
    }
}