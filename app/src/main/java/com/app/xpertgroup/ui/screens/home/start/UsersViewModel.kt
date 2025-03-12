package com.app.xpertgroup.ui.screens.home.start

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.xpertgroup.domain.useCases.GetUsersUseCase
import com.app.xpertgroup.ui.screens.home.data.HomeUiState
import com.app.xpertgroup.ui.theme.screens.navigation.NavigationItem
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UsersViewModel(
    private val getUsersUseCase: GetUsersUseCase
):ViewModel(){

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _navigateTo = MutableSharedFlow<NavigationItem>()
    val navigateTo: SharedFlow<NavigationItem> = _navigateTo

    fun getUsers() = viewModelScope.launch {
        getUsersUseCase(
             Unit,
             viewModelScope
        ){
            it.fold(
                onSuccess = { users ->
                    _uiState.update {
                        it.copy(
                            listUsers = users
                        )
                    }
                    Log.d("users","$users")
                },
                onFailure = { error ->
                    Log.d("users-err","$error")
                }
            )
        }

    }
}