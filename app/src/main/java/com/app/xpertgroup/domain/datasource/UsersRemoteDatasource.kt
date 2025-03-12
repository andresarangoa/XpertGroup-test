package com.app.xpertgroup.domain.datasource

import com.app.xpertgroup.domain.model.User
import retrofit2.Call

interface UsersRemoteDatasource {
    fun getUsers(): Call<List<User>>
}