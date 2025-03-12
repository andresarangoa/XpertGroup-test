package com.app.xpertgroup.ui.theme.screens.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun StartScreen(
    usersViewModel: UsersViewModel, navController: NavController
) {
    Text(text = "hola", style = TextStyle(color = Color.Black, fontSize = 30.sp))
}