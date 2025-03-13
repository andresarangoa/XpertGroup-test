package com.app.xpertgroup.domain.datasource

import com.app.xpertgroup.domain.modelDomain.UserEntity
import com.app.xpertgroup.data.databaseEntities.UserFull

interface UsersLocalDataSource {
    suspend fun getUsers():List<UserFull>
    suspend fun saveUsers(users : List<UserEntity>)
    suspend fun getUsersByName(name: String): List<UserFull>
}