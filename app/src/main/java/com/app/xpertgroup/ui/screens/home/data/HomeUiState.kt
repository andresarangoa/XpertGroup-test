package com.app.xpertgroup.ui.screens.home.data

import com.app.xpertgroup.domain.modelDomain.UserDomain

data class HomeUiState(
    val listUsers: List<UserDomain> = emptyList(),
    val nameToSearch: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = "",
)