package com.example.store.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.store.ProfileViewModel
import com.example.store.compose.Profile.Login


@Composable
fun Profile(navController: NavController, viewModel: ProfileViewModel) {

    //navigate depending on login status
    viewModel.loginStatus.observe(LocalLifecycleOwner.current) {
        if (it == false) {
            //show login page
            navController.navigate("login")
        }
        else {
            //show account information page
            navController.navigate("account")
        }
    }
}

fun NavGraphBuilder.ProfileGraph(navController: NavController, viewModel: ProfileViewModel) {
    navigation(startDestination = "login", "profile") {
        composable("login") {
            Login(navController = navController, viewModel = viewModel)
        }
        composable("register") {
            Login(navController = navController, viewModel = viewModel)
        }
    }
}