package com.app.xpertgroup.ui.screens.components.customBar

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.app.xpertgroup.R
import com.app.xpertgroup.ui.screens.components.foundation.RobotoTypography
import com.app.xpertgroup.ui.screens.components.foundation.getCustomIconBasedOnTheme
import com.app.xpertgroup.ui.screens.components.inputs.DefaultInputStateImp
import com.app.xpertgroup.ui.screens.components.inputs.InputTypes
import com.app.xpertgroup.ui.theme.LocalCustomColorsPalette
import com.app.xpertgroup.ui.screens.components.inputs.filled.FilledTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    title: String,
    onMenuClick: () -> Unit ={},
    onSearchChanged: (String) -> Unit ={},
    onMoreClick: () -> Unit ={}
) {
    var inputShowed by remember { mutableStateOf(false) }
    var filledSearchTxt by remember { mutableStateOf("") }
    val customIcons = getCustomIconBasedOnTheme(
        isSystemInDarkTheme()
    )
    TopAppBar(
        title = {
            if(inputShowed){
                FilledTextField(
                    label = R.string.label_search,
                    state = DefaultInputStateImp(
                        text = filledSearchTxt,
                        icon = customIcons.cancel,
                        inputType = InputTypes.TEXT,
                        onTextChanged = {
                            filledSearchTxt = it
                            onSearchChanged(it)
                        },
                        onIconClick ={
                            filledSearchTxt = ""
                            onSearchChanged("")
                        }
                    )
                )
            }else{
                Text(
                    text = title,
                    color = LocalCustomColorsPalette.current.textFormatedPrimary,
                    style = RobotoTypography.titleMedium
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = LocalCustomColorsPalette.current.textFormatedPrimary,
                )
            }
        },
        actions = {
            IconButton(onClick = { inputShowed = !inputShowed }) {
                Icon(
                    imageVector = if (inputShowed) Icons.Default.Clear else Icons.Default.Search,
                    contentDescription = if (inputShowed) "Clear" else "Search",
                    tint = LocalCustomColorsPalette.current.textFormatedPrimary
                )
            }
            IconButton(onClick = onMoreClick) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More",
                    tint = LocalCustomColorsPalette.current.textFormatedPrimary
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = LocalCustomColorsPalette.current.surfaceTertiary
        )
    )
}