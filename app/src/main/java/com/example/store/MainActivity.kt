package com.example.store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.example.store.ui.theme.StoreTheme
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.store.compose.Cart
import com.example.store.layout.Home
import com.example.store.layout.ProductDetails
import com.example.store.layout.Profile.ProfileGraph
import com.example.store.utils.NavigationItem
import com.example.store.viewModels.HomeViewModel
import com.example.store.viewModels.ProductDetailsViewModel
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

    Scaffold {

        NavHost(navController = navController, startDestination = NavigationItem.Home.route) {

            composable(NavigationItem.Home.route) {
                val viewModel = hiltViewModel<HomeViewModel>()
                Home(navController, viewModel)
            }

            composable(
                NavigationItem.ProductDetails.route,
                arguments = listOf(
                    navArgument("product_id") { type = NavType.IntType }
                )
            ) {
                //arguments
                val viewModel = hiltViewModel<ProductDetailsViewModel>()
                val id = it.arguments?.getInt("product_id")!!

                ProductDetails(navController, viewModel, id)
            }

            composable(NavigationItem.Cart.route) {
                Cart(navController)
            }

            ProfileGraph(navController)
        }
    }
}
