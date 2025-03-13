package com.app.xpertgroup.ui.screens.components.empty

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.app.xpertgroup.ui.screens.components.foundation.ConstantsValuesDp
import com.app.xpertgroup.ui.screens.components.foundation.RobotoTypography
import com.app.xpertgroup.ui.screens.components.utils.EMPTY_CARD_USERS
import com.app.xpertgroup.ui.screens.components.utils.rememberEmptyComponentState
import com.app.xpertgroup.ui.theme.LocalCustomColorsPalette

@Composable
fun EmptyComponentMessage(
    modifier: Modifier = Modifier,
    state: EmptyMessageState = rememberEmptyComponentState()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LocalCustomColorsPalette.current.surfacePrimary)
            .padding(horizontal = ConstantsValuesDp.value_dp_20)
            .testTag(EMPTY_CARD_USERS),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(ConstantsValuesDp.value_dp_40))
        Box {
            Text(
                text = state.title,
                textAlign = TextAlign.Center,
                style = RobotoTypography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = LocalCustomColorsPalette.current.textPrimary
                ),
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        Spacer(Modifier.height(ConstantsValuesDp.value_dp_20))
        Box {
            Text(
                text = state.subTitle,
                color = LocalCustomColorsPalette.current.textSecondary,
                style = RobotoTypography.titleMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}