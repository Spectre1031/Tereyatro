package components

import com.example.teyatro.navigation.Screen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.teyatro.R

@Composable
fun BottomNavigationBar(
    currentRoute: String = "",
    onNavigate: (String) -> Unit = {}
) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        containerColor = Color.Black
    ) {
        val navigationItems = listOf(
            NavigationItem(
                route = Screen.Home.route,
                icon = R.drawable.ic_home,
                description = "Home",
                iconSize = 30.dp
            ),
            NavigationItem(
                route = Screen.Search.route,
                icon = R.drawable.ic_search,
                description = "Search",
                iconSize = 24.dp
            ),
            NavigationItem(
                route = Screen.Watchlist.route,
                icon = R.drawable.ic_watchlist,
                description = "Watchlist",
                iconSize = 24.dp
            ),
            NavigationItem(
                route = Screen.Language.route,
                icon = R.drawable.ic_change_language,
                description = "Language",
                iconSize = 35.dp
            )
        )

        navigationItems.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.description,
                        modifier = Modifier.size(item.iconSize)
                    )
                },
                selected = currentRoute == item.route,
                onClick = { onNavigate(item.route) },
                colors = NavigationBarItemDefaults.colors(
                    unselectedIconColor = Color.White,
                    selectedIconColor = Color.White,
                    indicatorColor = Color.Black
                )
            )
        }
    }
}

private data class NavigationItem(
    val route: String,
    val icon: Int,
    val description: String,
    val iconSize: androidx.compose.ui.unit.Dp
)