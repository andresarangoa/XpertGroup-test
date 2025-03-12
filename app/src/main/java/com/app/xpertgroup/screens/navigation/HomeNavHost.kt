package com.app.xpertgroup.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.compose.NavHost
import com.app.xpertgroup.screens.home.UsersViewModel

@Composable
fun AuthenticationNavHost(
    navController: NavHostController,
    usersViewModel: UsersViewModel,
    modifier: Modifier = Modifier,
    startDestination: String = NavigationItem.Start.route,
) {
    NavHost(
        modifier = modifier.semantics {
            testTagsAsResourceId = true
        },
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Start.route) {
            StartScreen(navController = navController, viewModel = authenticationViewModel)
        }
    }
}