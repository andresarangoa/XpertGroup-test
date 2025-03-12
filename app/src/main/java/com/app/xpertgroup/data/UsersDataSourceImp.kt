package com.app.xpertgroup.data

import com.app.xpertgroup.domain.datasource.UsersLocalDataSource
import com.app.xpertgroup.domain.datasource.UsersRemoteDatasource
import com.app.xpertgroup.domain.model.User
import com.app.xpertgroup.domain.repository.Api
import com.app.xpertgroup.domain.utils.request
import kotlinx.coroutines.runBlocking
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
    override fun getUsers(): Call<List<User>> =  usersApi.getUsers()
}