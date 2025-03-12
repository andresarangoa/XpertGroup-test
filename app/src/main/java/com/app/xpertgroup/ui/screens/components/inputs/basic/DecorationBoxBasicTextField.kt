package com.app.xpertgroup.ui.screens.components.inputs.basic

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.app.xpertgroup.ui.screens.components.foundation.ConstantsValuesDp
import com.app.xpertgroup.ui.screens.components.foundation.Padding
import com.app.xpertgroup.ui.screens.components.inputs.DefaultInputStateI
import com.app.xpertgroup.ui.screens.components.inputs.DefaultInputTheme
import com.app.xpertgroup.ui.screens.components.inputs.defaultTheme
import com.app.xpertgroup.ui.screens.components.inputs.modifierDecorationBoxBasic
import com.app.xpertgroup.ui.screens.components.inputs.shouldShowIcon
import com.app.xpertgroup.ui.screens.components.utils.TEXT_DECORATION_BOX
import com.app.xpertgroup.ui.screens.components.utils.rememberDefaultInputState

@Composable
internal fun DecorationBoxBasicTextField(
    modifier: Modifier = Modifier,
    state: DefaultInputStateI = rememberDefaultInputState(),
    theme: DefaultInputTheme = defaultTheme(),
    innerTextField: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(start = Padding.normal)
            .testTag(TEXT_DECORATION_BOX),
        verticalAlignment = Alignment.CenterVertically
    ) {


        Box(
            modifier = modifier
                .modifierDecorationBoxBasic(state)
                .weight(1f), // Use weight to fill remaining space
            contentAlignment = Alignment.CenterStart
        ) {
            Column {
                PlaceholderInput(state, modifier)
                Row {
                    innerTextField()
                }
            }
        }
        state.icon?.let {
            if (state.shouldShowIcon()) {
                Row {
                    Box(
                        modifier = Modifier
                            .padding(end = Padding.large)
                            .align(Alignment.CenterVertically), contentAlignment = Alignment.Center
                    ) {
                        IconDefault(iconTheme = IconTheme(
                            icon = it, tint = theme.tint
                        ), modifier = Modifier
                            .clickable {
                                state.onIconClick()
                            }
                            .size(ConstantsValuesDp.value_dp_19))
                    }
                }
            }
        }
    }
}