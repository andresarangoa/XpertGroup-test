package com.app.xpertgroup.di

import com.app.xpertgroup.ui.theme.screens.home.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        UsersViewModel()
    }
}