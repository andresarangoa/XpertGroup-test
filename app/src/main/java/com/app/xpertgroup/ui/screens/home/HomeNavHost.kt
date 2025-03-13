package com.app.xpertgroup.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.xpertgroup.ui.screens.home.start.StartScreen
import com.app.xpertgroup.ui.screens.home.start.UsersViewModel
import com.app.xpertgroup.ui.screens.MainNavigationController
import com.app.xpertgroup.ui.screens.navigation.NavigationItem

data class NavigationControllers(
    val mainNavigationController: MainNavigationController?,
    val navController: NavHostController,
)

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeNavHost(
    navController: NavigationControllers,
    usersViewModel: UsersViewModel,
    modifier: Modifier = Modifier,
    startDestination: String = NavigationItem.Start.route,
) {
    NavHost(
        modifier = modifier.semantics {
            testTagsAsResourceId = true
        },
        navController = navController.navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Start.route) {
            StartScreen( usersViewModel = usersViewModel)
        }
    }
}