package com.app.xpertgroup.ui.screens.home.data

import com.app.xpertgroup.domain.modelDomain.UserEntity

data class HomeUiState(
    val listUsers: List<UserEntity> = emptyList(),
    val nameToSearch: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = "",
)