package com.app.xpertgroup.ui.screens.home.start

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.xpertgroup.domain.useCases.GetUsersByNameUseCase
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
    private val getUsersUseCase: GetUsersUseCase,
    private val getUsersByNameUseCase: GetUsersByNameUseCase
):ViewModel(){

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _navigateTo = MutableSharedFlow<NavigationItem>()
    val navigateTo: SharedFlow<NavigationItem> = _navigateTo

    fun getUsersByName() = viewModelScope.launch {
        setLoading(true)
        if(uiState.value.nameToSearch.isNotBlank()){
            getUsersByNameUseCase(
                GetUsersByNameUseCase.Params(uiState.value.nameToSearch),
                viewModelScope
            ){
                it.fold(
                    onSuccess = { users ->

                        _uiState.update {
                            it.copy(
                                listUsers = users,
                                isLoading = false
                            )
                        }
                    },
                    onFailure = { error ->
                        setLoading(false)
                        Log.d("users-err","$error")
                    }
                )
            }
        }else{
            getUsers()
        }
    }

    fun onSearchTextChanged(text: String){
        _uiState.update {
            it.copy(
                nameToSearch = text
            )
        }
    }

    fun getUsers() = viewModelScope.launch {
        setLoading(true)
        getUsersUseCase(
             Unit,
             viewModelScope
        ){
            it.fold(
                onSuccess = { users ->
                    _uiState.update {
                        it.copy(
                            listUsers = users,
                            isLoading = false
                        )
                    }
                },
                onFailure = { error ->
                    setLoading(false)
                    Log.d("users-err","$error")
                }
            )
        }
    }

    fun setLoading(value: Boolean){
        _uiState.update {
            it.copy(
                isLoading = value
            )
        }
    }

}