package com.app.xpertgroup.domain.useCases

import com.app.xpertgroup.domain.modelDomain.UserDomain
import com.app.xpertgroup.domain.repository.UsersRepository

class GetUsersByNameUseCase(private val usersRepository: UsersRepository)
    : UseCase<List<UserDomain>, GetUsersByNameUseCase.Params>() {
    data class Params(val name: String)

    override suspend fun run(params: Params?): Result<List<UserDomain>> = usersRepository.getUsersByName(name = params?.name?:"")
}