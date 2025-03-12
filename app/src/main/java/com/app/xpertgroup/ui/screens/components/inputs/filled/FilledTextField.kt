package com.app.xpertgroup.ui.screens.components.inputs.filled

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.app.xpertgroup.R
import com.app.xpertgroup.ui.screens.components.inputs.DefaultInputStateImp
import com.app.xpertgroup.ui.screens.components.utils.FILLED_INPUT_ID
import com.app.xpertgroup.ui.screens.components.utils.rememberDefaultInputState
import com.app.xpertgroup.ui.screens.components.inputs.basic.BasicTextField
import com.app.xpertgroup.ui.screens.components.inputs.DefaultInputTheme
import com.app.xpertgroup.ui.screens.components.inputs.filledTheme

@Composable
fun FilledTextField(
    modifier: Modifier = Modifier,
    hintModifier: Modifier = Modifier,
    @StringRes hint: Int = R.string.label_hint,
    @StringRes label: Int = R.string.label,
    state: DefaultInputStateImp = rememberDefaultInputState(),
    theme: DefaultInputTheme = filledTheme()
) {
    val combinedModifier = theme.modifier
        .then(modifier)
        .height(theme.height)
        .testTag(FILLED_INPUT_ID)

    BasicTextField(
        modifier = combinedModifier,
        hintModifier = hintModifier,
        hint = hint,
        label = label,
        state = state,
        theme = theme
    )
}