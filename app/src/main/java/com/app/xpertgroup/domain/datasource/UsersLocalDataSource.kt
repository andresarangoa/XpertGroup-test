package com.app.xpertgroup.domain.datasource

import com.app.xpertgroup.domain.modelDomain.UserDomain
import com.app.xpertgroup.data.local.databaseEntities.UserFull

interface UsersLocalDataSource {
    suspend fun getUsers():List<UserFull>
    suspend fun saveUsers(users : List<UserDomain>)
    suspend fun getUsersByName(name: String): List<UserFull>
}