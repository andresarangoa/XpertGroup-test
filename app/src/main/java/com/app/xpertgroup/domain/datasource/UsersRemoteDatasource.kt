package com.app.xpertgroup.domain.datasource

import com.app.xpertgroup.data.remote.model.UserResponse
import retrofit2.Call

interface UsersRemoteDatasource {
    fun getUsers(): Call<List<UserResponse>>
}