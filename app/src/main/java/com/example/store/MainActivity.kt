package com.example.store

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.store.ui.theme.StoreTheme
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.data.utils.Constants
import com.example.data.utils.NavigationItem
import com.example.store.compose.Cart
import com.example.store.compose.Category
import com.example.store.compose.Home
import com.example.store.layout.Profile.ProfileGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StoreTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                Constants.BottomNavigationItems.forEach { screen ->
                    BottomNavigationItem(
                        modifier = Modifier.background(colorResource(id = R.color.white)),
                        icon = {
                            Icon(
                                ImageVector.vectorResource(id = screen.icon),
                                contentDescription = null
                            )
                        },
                        selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        selectedContentColor = Color.DarkGray,
                        unselectedContentColor = Color.LightGray
                    )
                }
            }
        }
    ) {

        NavHost(navController = navController, startDestination = NavigationItem.Home.route) {

            composable(NavigationItem.Home.route) {
                Home(navController)
            }

            composable(NavigationItem.Category.route) {
                Category(navController)
            }

            composable(NavigationItem.Cart.route) {
                Cart(navController)
            }

            ProfileGraph(navController)
        }
    }
}
