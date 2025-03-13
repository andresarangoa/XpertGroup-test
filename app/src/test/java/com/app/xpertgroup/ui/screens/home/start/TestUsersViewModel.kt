package com.app.xpertgroup.ui.screens.home.start

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.app.xpertgroup.domain.repository.UsersRepository
import com.app.xpertgroup.domain.useCases.GetUsersByNameUseCase
import com.app.xpertgroup.domain.useCases.GetUsersUseCase
import com.app.xpertgroup.ui.utils.sampleUser
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.test.AutoCloseKoinTest

@OptIn(ExperimentalCoroutinesApi::class)
class TestUsersViewModel : AutoCloseKoinTest() {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK(relaxed = true)
    private lateinit var mockRepository: UsersRepository

    @MockK(relaxed = true)
    private lateinit var mockGetUsersUseCase: GetUsersUseCase

    @MockK(relaxed = true)
    private lateinit var mockGetUsersByNameUseCase: GetUsersByNameUseCase

    private val dispatcher = StandardTestDispatcher()

    private lateinit var viewModel: UsersViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        Dispatchers.setMain(dispatcher)


        mockGetUsersUseCase = GetUsersUseCase(mockRepository)
        mockGetUsersByNameUseCase = GetUsersByNameUseCase(mockRepository)

        viewModel = UsersViewModel(getUsersUseCase = mockGetUsersUseCase, getUsersByNameUseCase =mockGetUsersByNameUseCase )
    }

    @After
    fun tearDown() {

        unmockkAll()

        Dispatchers.resetMain()
    }

    @Test
    fun test_onSearchTextChanged() = runTest {
        val testSearch = "test"

        viewModel.onSearchTextChanged(testSearch)

        val uiState = async {
            viewModel.uiState.first()
        }

        assertEquals(testSearch, uiState.await().nameToSearch)
    }

    @Test
    fun test_onGetUsersRetrieveData() = runTest {
        viewModel.getUsers()

        coEvery {
            mockRepository.getUsers()
        } returns Result.success(listOf(sampleUser))

        val uiState = async {
            viewModel.uiState.first{ it.listUsers.isNotEmpty() }
        }

        assertEquals(sampleUser.id, uiState.await().listUsers[0].id)
    }

    @Test
    fun test_onGetUsersByNameRetrieveData() = runTest {
        viewModel.onSearchTextChanged(sampleUser.name ?: "")
        viewModel.getUsersByName()

        coEvery {
            mockRepository.getUsersByName(sampleUser.name ?: "")
        } returns Result.success(listOf(sampleUser))

        val uiState = async {
            viewModel.uiState.first { it.listUsers.isNotEmpty() }
        }

        val resultState = uiState.await()

        assertTrue(resultState.listUsers.isNotEmpty())

        assertEquals(sampleUser.id, resultState.listUsers[0].id)
    }

    @Test
    fun test_onGetUsersByNameWithNonExistingName() = runTest {
        val nonExistingName = "NonExistentName"
        viewModel.onSearchTextChanged(nonExistingName)
        viewModel.getUsersByName()

        coEvery {
            mockRepository.getUsersByName(eq(nonExistingName))
        } returns Result.success(emptyList())

        val uiState = async {
            viewModel.uiState.first { it.listUsers.isEmpty() }
        }

        assertTrue(uiState.await().listUsers.isEmpty())
    }
}