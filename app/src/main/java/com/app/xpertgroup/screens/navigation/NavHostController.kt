package com.app.xpertgroup.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.app.xpertgroup.screens.home.UsersViewModel

enum class Screen {
    BACK,
    START,
}

sealed class NavigationItem(val route: String) {
    data object Back : NavigationItem(Screen.BACK.name)
    data object Start : NavigationItem(Screen.START.name)
}

/**
 * A composable function that handles navigation based on events from the AuthenticationViewModel.
 *
 * @param navController The NavController which controls navigation within the app.
 * @param viewModel The AuthenticationViewModel which emits navigation events.
 */
@Composable
fun HandleAuthenticationNavigation(
    navController: NavController,
    viewModel: UsersViewModel
) {
    // Use LaunchedEffect to collect from the ViewModel's navigateTo SharedFlow
    // This ensures that the collection is cancelled when the composable is disposed
    LaunchedEffect(viewModel) {
        viewModel.navigateTo.collect { navigationItem ->
            when (navigationItem) {
                is NavigationItem.Back -> navController.popBackStack()
                is NavigationItem.Start -> navController.navigate(navigationItem.route)
            }
        }
    }
}
