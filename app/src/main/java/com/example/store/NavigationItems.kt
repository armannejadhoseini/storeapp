package com.example.store

sealed class NavigationItem(var route: String, var icon: Int) {
    object Home : NavigationItem("home", R.drawable.ic_home)
    object Music : NavigationItem("music", R.drawable.ic_music)
    object Movies : NavigationItem("movies", R.drawable.ic_move)
    object Books : NavigationItem("books", R.drawable.ic_book)
    object Profile : NavigationItem("profile", R.drawable.ic_profile)
}