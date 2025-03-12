package com.app.xpertgroup.ui.screens.home.start

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.app.xpertgroup.ui.screens.components.foundation.ConstantsValuesDp
import com.app.xpertgroup.ui.screens.components.userCard.UserCard
import com.app.xpertgroup.ui.screens.home.start.UsersViewModel
import com.app.xpertgroup.ui.theme.LocalCustomColorsPalette
import com.app.xpertgroup.ui.theme.XpertGroupTheme

@Composable
fun StartScreen(
    usersViewModel: UsersViewModel, navController: NavController
) {
    Text(text = "hola", style = TextStyle(color = Color.Black, fontSize = 30.sp))
    val uiState = usersViewModel.uiState.collectAsState().value
    val listUsers = uiState.listUsers
    LaunchedEffect(true) {
        usersViewModel.getUsers()
    }
    XpertGroupTheme {
        Surface(color = LocalCustomColorsPalette.current.surfacePrimary) {
            LazyColumn(modifier = Modifier.fillMaxSize().padding(ConstantsValuesDp.value_dp_8)) {
                items( listUsers.size) { index ->
                    UserCard(user = listUsers[index])
                }
            }
        }
    }
}