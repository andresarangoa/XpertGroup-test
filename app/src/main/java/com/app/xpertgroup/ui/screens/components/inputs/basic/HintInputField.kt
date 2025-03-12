package com.app.xpertgroup.ui.screens.components.inputs.basic

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.app.xpertgroup.R
import com.app.xpertgroup.ui.screens.components.foundation.ConstantsValuesDp
import com.app.xpertgroup.ui.screens.components.foundation.RobotoTypography
import com.app.xpertgroup.ui.screens.components.inputs.DefaultInputStateI
import com.app.xpertgroup.ui.screens.components.inputs.DefaultInputTheme
import com.app.xpertgroup.ui.screens.components.inputs.defaultTheme
import com.app.xpertgroup.ui.screens.components.inputs.getHintStateColor
import com.app.xpertgroup.ui.screens.components.inputs.getHintStateIcon
import com.app.xpertgroup.ui.screens.components.inputs.getHintTextColor
import com.app.xpertgroup.ui.screens.components.utils.rememberDefaultInputState

@Composable
fun HintInputField(
    modifier: Modifier = Modifier,
    state: DefaultInputStateI = rememberDefaultInputState(),
    theme: DefaultInputTheme = defaultTheme()
) {
    val combinedHintModifier = theme.hintModifier.then(modifier)

    Row(modifier = combinedHintModifier) {
        when {
            state.showHint -> HintText(state.hint, theme, state)
            state.showError || state.showSuccess -> {
                FeedbackIcon(state, theme)
                HintText(state.hint, theme, state)
            }
        }
    }
}

@Composable
fun FeedbackIcon(state: DefaultInputStateI, theme: DefaultInputTheme) {
    Icon(
        painter = painterResource(id = theme.getHintStateIcon(state)),
        contentDescription = stringResource(id = R.string.label_hint),
        tint = theme.getHintStateColor(state),
        modifier = Modifier.size(ConstantsValuesDp.value_dp_15)
    )
}

@Composable
fun HintText(hint: String, theme: DefaultInputTheme, state: DefaultInputStateI) {
    Text(
        text = hint,
        color = theme.getHintTextColor(state),
        style = RobotoTypography.headlineMedium
    )
}