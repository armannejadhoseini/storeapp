package com.example.store.layout.Profile


import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.store.layout.profile.Login
import com.example.store.viewModels.HomeViewModel


fun NavGraphBuilder.ProfileGraph(navController: NavController) {
    navigation(startDestination = "login", "profile") {
        composable("login") {
            val viewModel = hiltViewModel<HomeViewModel>()
            Login(navController = navController, viewModel = viewModel)
        }
        composable("account") {
            val viewModel = hiltViewModel<HomeViewModel>()
            Account(navController = navController, viewModel = viewModel)
        }
    }
}