package com.app.xpertgroup.ui.screens.home.start

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onParent
import androidx.navigation.NavController
import com.app.xpertgroup.domain.modelDomain.UserEntity
import com.app.xpertgroup.ui.config.BaseSnapshotTest
import com.app.xpertgroup.ui.config.Constants
import com.app.xpertgroup.ui.config.SnapshotRobot
import com.app.xpertgroup.ui.config.TestCase
import com.app.xpertgroup.ui.screens.components.utils.NodeTags.START_SCREEN_ROOT_TAG
import com.app.xpertgroup.ui.screens.home.data.HomeUiState
import com.app.xpertgroup.ui.theme.XpertGroupTheme
import com.app.xpertgroup.ui.screens.navigation.NavigationItem
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.runTest
import org.junit.Test

class TestStartScreen : BaseSnapshotTest() {

    private val mockNavController = mockk<NavController>(relaxed = true)
    private val mockViewModel = mockk<UsersViewModel>(relaxed = true)

    override fun setup() {
        MockKAnnotations.init(this)

        robot = SnapshotRobot(
            Constants.Screenshot.PATH_AUTHENTICATION_START_SCREEN,
            activityScenarioRule
        )
        every { mockViewModel.navigateTo } returns MutableStateFlow<NavigationItem>(NavigationItem.Start)
        every { mockViewModel.uiState } returns MutableStateFlow(HomeUiState())
    }

    override fun tearDown() {
        unmockkAll()
    }

    @Test
    fun testStartScreen() = runTest {
        runSnapshotTestsForContent(
            robot.getTestCases(
                this@TestStartScreen::class.simpleName.orEmpty(),
                "testStartScreen"
            )
        ) {
            XpertGroupTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    StartScreen( usersViewModel = mockViewModel)
                }
            }
        }
    }

    @Test
    fun testStartScreenWithUsers() = runTest {
        // Configure the mocked UI state to include a list of users
        every { mockViewModel.uiState.value.listUsers } returns listOf(UserEntity(name = "test"))

        runSnapshotTestsForContent(
            robot.getTestCases(
                this@TestStartScreen::class.simpleName.orEmpty(),
                "testStartScreenWithUsers"
            )
        ) {
            XpertGroupTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    StartScreen(usersViewModel = mockViewModel)
                }
            }
        }
    }

    override fun runSnapshotTestsForContent(
        testCases: List<TestCase>,
        content: @Composable () -> Unit
    ) = robot.run {
        testCases.forEach {
            initTestCaseData(it)
            initActivityAndSetContent {
                content()
            }
            takeScreenshot(it, getTestNode())
        }
    }

    override fun getTestNode(): SemanticsNodeInteraction =
        composeRule.onNodeWithTag(START_SCREEN_ROOT_TAG)
            .assertExists()
            .assertIsDisplayed()
            .onParent()

}