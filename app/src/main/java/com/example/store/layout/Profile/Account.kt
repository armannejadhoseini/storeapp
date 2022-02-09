package com.example.store.layout.Profile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.store.viewModels.ProfileViewModel

@Composable
fun Account(navController: NavController, viewModel: ProfileViewModel) {
    Text(modifier = Modifier.fillMaxSize(), text = "account")

}