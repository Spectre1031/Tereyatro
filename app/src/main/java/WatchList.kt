import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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

@Composable
fun WatchlistScreen() {
    Scaffold(
        topBar = { WatchlistHeader() },
        bottomBar = { BottomNavigationBar() },
        content = { padding -> WatchlistGrid(padding) }
    )
}

@Composable
fun WatchlistHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "NAME'S WATCHLIST!",
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = 24.sp),
            color = Color.Black
        )
    }
}

@Composable
fun WatchlistGrid(padding: PaddingValues) {
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
                row.forEach { poster: Int ->
                    MoviePosterWithInfo(posterRes = poster)
                }
            }
        }
    }
}

@Composable
fun MoviePosterWithInfo(posterRes: Int) {
    Box(
        modifier = Modifier.wrapContentSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = posterRes),
                contentDescription = "Movie Poster",
                modifier = Modifier.size(120.dp)
            )
            Surface(
                shape = CircleShape,
                color = Color.Black,
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_alert),
                    contentDescription = "Info Icon",
                    tint = Color.White,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
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
            WatchlistScreen()
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        containerColor = Color.Black
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier.size(30.dp)
                )
            },
            selected = true,
            onClick = { /* Handle click */ },
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = Color.White,
                selectedIconColor = Color.White,
                indicatorColor = Color.Black
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                    modifier = Modifier.size(24.dp)
                )
            },
            selected = false,
            onClick = { /* Handle click */ },
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = Color.White,
                selectedIconColor = Color.White,
                indicatorColor = Color.Black
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_watchlist),
                    contentDescription = "Watchlist",
                    modifier = Modifier.size(24.dp)
                )
            },
            selected = false,
            onClick = { /* Handle click */ },
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = Color.White,
                selectedIconColor = Color.White,
                indicatorColor = Color.Black
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_change_language),
                    contentDescription = "Language",
                    modifier = Modifier.size(35.dp)
                )
            },
            selected = false,
            onClick = { /* Handle click */ },
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = Color.White,
                selectedIconColor = Color.White,
                indicatorColor = Color.Black
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WatchlistHeaderPreview() {
    TeyatroTheme {
        WatchlistHeader()
    }
}

@Preview(showBackground = true)
@Composable
fun WatchlistGridPreview() {
    TeyatroTheme {
        WatchlistGrid(PaddingValues(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MoviePosterWithInfoPreview() {
    TeyatroTheme {
        MoviePosterWithInfo(posterRes = R.drawable.filler_image)
    }
}