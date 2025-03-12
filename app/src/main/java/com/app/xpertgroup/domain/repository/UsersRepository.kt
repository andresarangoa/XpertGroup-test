package com.app.xpertgroup.domain.repository

import com.app.xpertgroup.domain.model.User

interface UsersRepository {
    fun getUsers():Result<List<User>>
}