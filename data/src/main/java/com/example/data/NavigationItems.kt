package com.example.store

import com.example.data.R

sealed class NavigationItem(var route: String, var icon: Int) {
    object Home : NavigationItem("home", R.drawable.ic_home)
    object Category : NavigationItem("category", R.drawable.ic_baseline_category_24)
    object Cart : NavigationItem("cart", R.drawable.ic_baseline_shopping_cart_24)
    object Profile : NavigationItem("profile", R.drawable.ic_profile)
}