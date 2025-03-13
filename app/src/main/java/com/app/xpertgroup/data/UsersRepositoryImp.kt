package com.app.xpertgroup.data

import com.app.xpertgroup.data.local.datasources.UsersLocalDataSourceImp
import com.app.xpertgroup.domain.modelDomain.UserDomain
import com.app.xpertgroup.data.platform.NetworkHandler
import com.app.xpertgroup.data.mappers.listUserFullToListUserEntity
import com.app.xpertgroup.data.mappers.toListUserEntity
import com.app.xpertgroup.data.remote.datasources.UsersRemoteDataSourceImp
import com.app.xpertgroup.domain.repository.UsersRepository
import com.app.xpertgroup.domain.utils.request

class UsersRepositoryImp(
    val usersRemoteDataSourceImp: UsersRemoteDataSourceImp,
    val usersLocalDataSourceImp: UsersLocalDataSourceImp,
    val networkHandler: NetworkHandler
):UsersRepository{
    override suspend fun getUsers(): Result<List<UserDomain>> {
        return if (networkHandler.isNetworkAvailable()) {
            val result = request(
                usersRemoteDataSourceImp.getUsers(),
                { remoteUsers -> remoteUsers.toListUserEntity() },
                listOf()
            )
            result.onSuccess { userEntities ->
                usersLocalDataSourceImp.saveUsers(userEntities)
            }
            result
        } else {
            val localUsers = usersLocalDataSourceImp.getUsers().listUserFullToListUserEntity()
            Result.success(localUsers)
        }
    }

    override suspend fun getUsersByName(name: String): Result<List<UserDomain>> {
        val localUsers = usersLocalDataSourceImp.getUsersByName(name).listUserFullToListUserEntity()
        return Result.success(localUsers)
    }
}