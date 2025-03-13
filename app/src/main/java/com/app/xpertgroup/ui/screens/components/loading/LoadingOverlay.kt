package com.app.xpertgroup.ui.screens.components.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import com.app.xpertgroup.ui.theme.LocalCustomColorsPalette

@Composable
fun LoadingOverlay(isLoading: Boolean, alpha: Float = 0.5f) {
    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(LocalCustomColorsPalette.current.surfaceTertiary.copy(alpha = alpha))
                .zIndex(1f) // Ensure the overlay is above other content
        ) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = LocalCustomColorsPalette.current.textPrimaryButton
            )
        }
    }
}
