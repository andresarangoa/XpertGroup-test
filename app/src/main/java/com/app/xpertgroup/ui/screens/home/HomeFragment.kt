package com.app.xpertgroup.ui.screens.home

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.app.xpertgroup.R
import com.app.xpertgroup.ui.screens.components.customBar.CustomTopBar
import com.app.xpertgroup.ui.theme.screens.MainNavigationController
import com.app.xpertgroup.ui.theme.XpertGroupTheme
import com.app.xpertgroup.ui.theme.screens.home.HomeNavHost
import com.app.xpertgroup.ui.theme.screens.home.NavigationControllers
import com.app.xpertgroup.ui.screens.home.start.UsersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val viewModel: UsersViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val navController = rememberNavController()

                XpertGroupTheme {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            CustomTopBar(
                                title = stringResource(R.string.label_title_users)
                            )
                        }
                    ){ padding ->
                        BackHandler {
                            activity?.moveTaskToBack(false)
                        }
                        Column(
                            modifier = Modifier
                                .padding(top = padding.calculateTopPadding())
                                .fillMaxSize()
                        ) {
                            HomeNavHost(
                                navController = NavigationControllers(
                                    mainNavigationController = activity as? MainNavigationController,
                                    navController = navController,
                                ),
                                usersViewModel = viewModel
                            )
                        }
                    }
                }
            }
        }
    }
}