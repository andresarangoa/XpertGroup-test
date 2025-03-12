package com.app.xpertgroup.ui.screens.components.inputs.basic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.graphics.Color
import com.app.xpertgroup.ui.screens.components.foundation.AppColorScheme
import com.app.xpertgroup.ui.theme.LocalCustomColorsPalette

data class IconTheme(
    var icon: Int? = null,
    var tint: Color? = null,
    var disableTint: Color? = null,
) {
    companion object {
        @Composable
        fun onSecondary(
            icon: Int?,
            customColor: ProvidableCompositionLocal<AppColorScheme> = LocalCustomColorsPalette
        ) = IconTheme(
            icon = icon,
            tint = customColor.current.textSecondaryButton,
            disableTint = customColor.current.textPrimary,
        )

        @Composable
        fun onPrimary(
            icon: Int?,
            customColor: ProvidableCompositionLocal<AppColorScheme> = LocalCustomColorsPalette
        ) = IconTheme(
            icon = icon,
            tint = customColor.current.textPrimaryButton,
            disableTint = customColor.current.textDisable,
        )
    }
}
