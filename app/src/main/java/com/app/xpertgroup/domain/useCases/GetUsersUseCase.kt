package com.app.xpertgroup.domain.useCases

import com.app.xpertgroup.domain.modelDomain.UserDomain
import com.app.xpertgroup.domain.repository.UsersRepository

class GetUsersUseCase(private val usersRepository: UsersRepository)
    : UseCase<List<UserDomain>, Unit>() {
    override suspend fun run(params: Unit?): Result<List<UserDomain>> = usersRepository.getUsers()
}