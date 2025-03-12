package com.app.xpertgroup.data

import com.app.xpertgroup.domain.model.User
import com.app.xpertgroup.domain.repository.UsersRepository
import com.app.xpertgroup.domain.utils.request

class UsersRepositoryImp(
    val usersRemoteDataSourceImp: UsersRemoteDataSourceImp
):UsersRepository{
    override fun getUsers(): Result<List<User>> {
       return request(
            usersRemoteDataSourceImp.getUsers(),
            {it},
            emptyList()
        )
    }
}