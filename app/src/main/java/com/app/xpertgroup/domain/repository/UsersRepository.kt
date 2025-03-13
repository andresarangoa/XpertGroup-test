package com.app.xpertgroup.domain.repository

import com.app.xpertgroup.domain.modelDomain.UserEntity

interface UsersRepository {
    suspend fun getUsers():Result<List<UserEntity>>
    suspend fun getUsersByName(name: String):Result<List<UserEntity>>
}