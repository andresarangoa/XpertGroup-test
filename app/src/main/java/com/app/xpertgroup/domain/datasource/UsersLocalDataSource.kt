package com.app.xpertgroup.domain.datasource

import com.app.xpertgroup.domain.model.User

interface UsersLocalDataSource {
    fun getUsers(): Result<List<User>>
}