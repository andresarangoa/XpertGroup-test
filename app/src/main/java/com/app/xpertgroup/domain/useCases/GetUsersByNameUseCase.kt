package com.app.xpertgroup.domain.useCases

import com.app.xpertgroup.data.model.UserEntity
import com.app.xpertgroup.domain.repository.UsersRepository

class GetUsersByNameUseCase(private val usersRepository: UsersRepository)
    : UseCase<List<UserEntity>, GetUsersByNameUseCase.Params>() {
    data class Params(val name: String)

    override suspend fun run(params: Params?): Result<List<UserEntity>> = usersRepository.getUsersByName(name = params?.name?:"")
}