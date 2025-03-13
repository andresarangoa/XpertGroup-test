package com.app.xpertgroup.data

import com.app.xpertgroup.data.model.UserEntity
import com.app.xpertgroup.data.platform.NetworkHandler
import com.app.xpertgroup.domain.mappers.listUserFullToListUserEntity
import com.app.xpertgroup.domain.mappers.toListUserEntity
import com.app.xpertgroup.domain.repository.UsersRepository
import com.app.xpertgroup.domain.utils.request

class UsersRepositoryImp(
    val usersRemoteDataSourceImp: UsersRemoteDataSourceImp,
    val usersLocalDataSourceImp: UsersLocalDataSourceImp,
    val networkHandler: NetworkHandler
):UsersRepository{
    override suspend fun getUsers(): Result<List<UserEntity>> {
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
            // Network unavailable: return local data
            val localUsers = usersLocalDataSourceImp.getUsers().listUserFullToListUserEntity()
            Result.success(localUsers)
        }
    }
}