package com.app.xpertgroup.ui.screens.navigation

enum class Screen {
    START,
}

sealed class NavigationItem(val route: String) {
    data object Start : NavigationItem(Screen.START.name)
}

