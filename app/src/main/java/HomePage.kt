package com.example.teyatro.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.teyatro.R
import androidx.compose.foundation.background
import androidx.compose.ui.tooling.preview.Preview
import com.example.teyatro.ui.theme.TeyatroTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import components.BottomNavigationBar

@Composable
fun HomePage(
    onNavigateToSearch: () -> Unit = {},
    onNavigateToWatchlist: () -> Unit = {},
    onNavigateToMovieDetails: () -> Unit
) {
    Scaffold(
        topBar = { HeaderSection() },
        bottomBar = { BottomNavigationBar(currentRoute = "home") }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            item { SearchBar() }
            item { MovieGrid() }
        }
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "TEYATRO",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            color = Color.Black
        )
    }
}

@Composable
fun SearchBar() {
    var query by remember { mutableStateOf("") }

    OutlinedTextField(
        value = query,
        onValueChange = { query = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .height(48.dp),
        placeholder = {
            Text(
                "Search",
                style = MaterialTheme.typography.bodyMedium
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search Icon",
                tint = Color.Gray,
                modifier = Modifier.size(15.dp)
            )
        },
        trailingIcon = {
            IconButton(
                onClick = { /* Handle filter click */ },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_filter),
                    contentDescription = "Filter",
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
            }
        },
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyMedium,
        shape = RoundedCornerShape(24.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Black,
            focusedBorderColor = Color.Black
        )
    )
}

@Composable
fun MovieGrid() {
    val featuredPosters = listOf(
        Pair(R.drawable.filler_image, "Featured Movie 1"),
        Pair(R.drawable.filler_image, "Featured Movie 2"),
        Pair(R.drawable.filler_image, "Featured Movie 3")
    )

    val regularPosters = listOf(
        Pair(R.drawable.filler_image, "Movie 1"),
        Pair(R.drawable.filler_image, "Movie 2"),
        Pair(R.drawable.filler_image, "Movie 3"),
        Pair(R.drawable.filler_image, "Movie 4"),
        Pair(R.drawable.filler_image, "Movie 5")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Featured Movies",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        FeaturedMovieRow(featuredPosters)

        Text(
            text = "Regular Movies",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        RegularMovieRows(regularPosters)
    }
}

@Composable
fun FeaturedMovieRow(posters: List<Pair<Int, String>>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(posters) { (poster, title) ->
            Column(
                modifier = Modifier
                    .width(200.dp)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(160.dp)
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    Image(
                        painter = painterResource(id = poster),
                        contentDescription = title,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

@Composable
fun RegularMovieRows(posters: List<Pair<Int, String>>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        repeat(3) { rowIndex ->
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(posters) { (poster, title) ->
                    Column(
                        modifier = Modifier
                            .width(120.dp)
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .height(150.dp)
                                .clip(RoundedCornerShape(12.dp))
                        ) {
                            Image(
                                painter = painterResource(id = poster),
                                contentDescription = title,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Text(
                            text = title,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 800)
@Composable
fun HomePagePreview() {
    TeyatroTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomePage(onNavigateToMovieDetails = {})
        }
    }
}