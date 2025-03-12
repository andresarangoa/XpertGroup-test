package com.app.xpertgroup.screens.home

import androidx.lifecycle.ViewModel
import com.app.xpertgroup.screens.navigation.NavigationItem
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class UsersViewModel():ViewModel(){
    private val _navigateTo = MutableSharedFlow<NavigationItem>()
    val navigateTo: SharedFlow<NavigationItem> = _navigateTo
}