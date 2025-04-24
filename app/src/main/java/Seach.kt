import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teyatro.R
import com.example.teyatro.ui.theme.TeyatroTheme
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import components.BottomNavigationBar
import com.example.teyatro.navigation.Screen


@Composable
fun SearchScreen(
    onBackClick: () -> Unit,
    onNavigateToMovieDetails: () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentRoute = Screen.Search.route,
                onNavigate = { /* Handle navigation */ }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
        ) {
            SearchHeader(onBackClick = onBackClick)
            Spacer(modifier = Modifier.height(10.dp))
            SearchBar(modifier = Modifier.height(40.dp))
            Spacer(modifier = Modifier.height(10.dp))
            SearchContent()
        }
    }
}

@Composable
private fun SearchHeader(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onBackClick,
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                modifier = Modifier.size(24.dp),
                tint = Color.Red
            )
        }

        IconButton(
            onClick = { /* Handle watchlist click */ },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_watchlist),
                contentDescription = "Watchlist",
                modifier = Modifier.size(25.dp),
                tint = Color.Red
            )
        }
    }
}

@Composable
private fun SearchBar(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }

    OutlinedTextField(
        value = query,
        onValueChange = { query = it },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 10.dp),

        placeholder = {
            Text(
                "Search",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search Icon",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(20.dp)
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
                    tint = Color.Red,
                    modifier = Modifier.size(20.dp)
                )
            }
        },
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            color = MaterialTheme.colorScheme.onSurface
        ),
        shape = RoundedCornerShape(25.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Black,
            focusedBorderColor = Color.Black
        )
    )
}

@Composable
private fun SearchContent() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Have You Seen This Movie?",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 8.dp),
            color = MaterialTheme.colorScheme.onBackground
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(6) {
                MoviePoster()
            }
        }
    }
}

@Composable
private fun MoviePoster() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(0.67f),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(0.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.filler_image),
                contentDescription = "Movie Poster",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    TeyatroTheme {
        MoviePoster()
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    TeyatroTheme {
        SearchBar()
    }
}

@Preview(showBackground = true)
@Composable
fun SearchHeaderPreview() {
    TeyatroTheme {
        SearchHeader(onBackClick = {})
    }
}

@Preview(showBackground = true, heightDp = 800)
@Composable
fun SearchScreenPreview() {
    TeyatroTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SearchScreen(
                onBackClick = {},
                onNavigateToMovieDetails = {}
            )
        }
    }
}