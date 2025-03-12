package com.app.xpertgroup.data

import com.app.xpertgroup.domain.datasource.UsersLocalDataSource
import com.app.xpertgroup.domain.datasource.UsersRemoteDatasource
import com.app.xpertgroup.domain.model.User
import com.app.xpertgroup.domain.model.UserResponse
import com.app.xpertgroup.domain.repository.Api
import retrofit2.Call

class UsersLocalDataSourceImp(

):UsersLocalDataSource {
    override fun getUsers(): Result<List<User>> {
        TODO("Not yet implemented")
    }
}

class UsersRemoteDataSourceImp(
    private val usersApi: Api
):UsersRemoteDatasource {
    override fun getUsers(): Call<List<UserResponse>> = usersApi.getUsers()
}