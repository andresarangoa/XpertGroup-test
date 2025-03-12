package com.app.xpertgroup.di

import com.app.xpertgroup.domain.useCases.GetUsersUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetUsersUseCase(usersRepository = get()) }
}