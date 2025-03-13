package com.app.xpertgroup.domain.repository

import com.app.xpertgroup.data.model.UserEntity

interface UsersRepository {
    suspend fun getUsers():Result<List<UserEntity>>
}