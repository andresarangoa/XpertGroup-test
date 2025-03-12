package com.app.xpertgroup.ui.screens.components.inputs.basic

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.app.xpertgroup.ui.screens.components.foundation.AppColors
import com.app.xpertgroup.ui.screens.components.foundation.RobotoTypography
import com.app.xpertgroup.ui.screens.components.inputs.DefaultInputStateI
import com.app.xpertgroup.ui.screens.components.inputs.isLabelVisible
import com.app.xpertgroup.ui.screens.components.inputs.modifierDecorationBoxBasic

@Composable
fun PlaceholderInput(
    state: DefaultInputStateI,
    modifier: Modifier
) {
    if (state.isLabelVisible()) {
        Text(
            text = state.label,
            style = RobotoTypography.headlineSmall.copy(color = AppColors.neutral600D)
        )
    } else {
        Box(
            modifier = modifier.modifierDecorationBoxBasic(state),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = state.label,
                style = RobotoTypography.bodyMedium.copy(color = AppColors.neutral600D)
            )
        }
    }
}