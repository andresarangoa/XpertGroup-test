package com.app.xpertgroup.ui.theme.screens.home

import androidx.lifecycle.ViewModel
import com.app.xpertgroup.ui.theme.screens.navigation.NavigationItem
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class UsersViewModel():ViewModel(){
    private val _navigateTo = MutableSharedFlow<NavigationItem>()
    val navigateTo: SharedFlow<NavigationItem> = _navigateTo
}