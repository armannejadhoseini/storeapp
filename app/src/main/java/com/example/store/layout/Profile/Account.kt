package com.example.store.layout.Profile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.store.viewModels.HomeViewModel

@Composable
fun Account(navController: NavController, viewModel: HomeViewModel) {
    Text(modifier = Modifier.fillMaxSize(), text = "account")

}