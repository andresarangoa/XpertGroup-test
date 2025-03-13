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

class GetAllUsersListTest : UnitTest() {

    private lateinit var getUsersUseCase: GetUsersUseCase

    @MockK
    private lateinit var usersRepository: UsersRepository

    @Before
    fun setUp() {
        getUsersUseCase = GetUsersUseCase(usersRepository)
        coEvery { usersRepository.getUsers() } returns Result.success(listOf(sampleUser))
    }

    @Test
    fun `should get data from repository`() {
        runBlocking { getUsersUseCase.run() }

        coVerify(exactly = 1) { usersRepository.getUsers() }
    }
}
