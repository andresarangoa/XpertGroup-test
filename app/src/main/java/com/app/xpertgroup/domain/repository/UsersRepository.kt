package com.app.xpertgroup.domain.repository

import com.app.xpertgroup.domain.modelDomain.UserDomain

interface UsersRepository {
    suspend fun getUsers():Result<List<UserDomain>>
    suspend fun getUsersByName(name: String):Result<List<UserDomain>>
}