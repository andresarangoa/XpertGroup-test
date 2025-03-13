package com.app.xpertgroup.data.remote.datasources

import com.app.xpertgroup.domain.datasource.UsersRemoteDatasource
import com.app.xpertgroup.data.remote.model.UserResponse
import com.app.xpertgroup.data.remote.api.Api
import retrofit2.Call


class UsersRemoteDataSourceImp(
    private val usersApi: Api
) : UsersRemoteDatasource {
    override fun getUsers(): Call<List<UserResponse>> = usersApi.getUsers()
}