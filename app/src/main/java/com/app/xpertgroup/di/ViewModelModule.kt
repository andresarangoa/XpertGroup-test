package com.app.xpertgroup.di

import com.app.xpertgroup.ui.screens.home.start.UsersViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { UsersViewModel(getUsersUseCase = get(), getUsersByNameUseCase = get()) }
}