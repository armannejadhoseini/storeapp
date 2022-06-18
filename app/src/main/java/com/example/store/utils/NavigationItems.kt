package com.example.store.utils


sealed class NavigationItem(var route: String) {
    object Home : NavigationItem("home")
    object Cart : NavigationItem("cart")
    object Profile : NavigationItem("profile")
    object ProductDetails : NavigationItem("product_details/{product_id}")
}