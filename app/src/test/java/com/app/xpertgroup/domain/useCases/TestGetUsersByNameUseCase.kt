package com.app.xpertgroup.domain.useCases

import com.app.xpertgroup.domain.repository.UsersRepository
import com.app.xpertgroup.domain.useCases.utils.UnitTest
import com.app.xpertgroup.ui.utils.sampleUser
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllUsersListByNameTest : UnitTest() {

    private lateinit var getUsersByNameUseCase: GetUsersByNameUseCase

    @MockK
    private lateinit var usersRepository: UsersRepository

    @Before
    fun setUp() {
        getUsersByNameUseCase = GetUsersByNameUseCase(usersRepository)
        coEvery { usersRepository.getUsersByName(sampleUser.name?:"") } returns Result.success(listOf(sampleUser))
    }

    @Test
    fun `should get data from repository`() {
        runBlocking { getUsersByNameUseCase.run(GetUsersByNameUseCase.Params(sampleUser.name?:"")) }

        coVerify(exactly = 1) { usersRepository.getUsersByName(sampleUser.name?:"") }
    }
}
