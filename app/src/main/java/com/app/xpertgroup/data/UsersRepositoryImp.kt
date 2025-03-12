package com.app.xpertgroup.data

import com.app.xpertgroup.data.model.UserEntity
import com.app.xpertgroup.domain.mappers.toListUserEntity
import com.app.xpertgroup.domain.repository.UsersRepository
import com.app.xpertgroup.domain.utils.request

class UsersRepositoryImp(
    val usersRemoteDataSourceImp: UsersRemoteDataSourceImp
):UsersRepository{
    override fun getUsers(): Result<List<UserEntity>> {
       return request(
            usersRemoteDataSourceImp.getUsers(),
            {it.toListUserEntity()},
            listOf()
        )
    }
}