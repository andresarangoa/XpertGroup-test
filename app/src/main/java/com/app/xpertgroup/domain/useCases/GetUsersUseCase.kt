package com.app.xpertgroup.domain.useCases

import com.app.xpertgroup.data.model.UserEntity
import com.app.xpertgroup.domain.repository.UsersRepository

class GetUsersUseCase(private val usersRepository: UsersRepository)
    : UseCase<List<UserEntity>, Unit>() {
    override suspend fun run(params: Unit?): Result<List<UserEntity>> = usersRepository.getUsers()
}