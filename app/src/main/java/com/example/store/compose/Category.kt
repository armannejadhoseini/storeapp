package com.example.store.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Category(navController: NavController) {
    Text(modifier = Modifier.fillMaxSize(), text = "Hello, World")
}