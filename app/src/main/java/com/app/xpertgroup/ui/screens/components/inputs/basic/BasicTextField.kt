package com.app.xpertgroup.ui.screens.components.inputs.basic

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import com.app.xpertgroup.R
import com.app.xpertgroup.ui.screens.components.foundation.ConstantsValuesDp
import com.app.xpertgroup.ui.screens.components.inputs.DefaultInputStateI
import com.app.xpertgroup.ui.screens.components.inputs.DefaultInputTheme
import com.app.xpertgroup.ui.screens.components.inputs.defaultTheme
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_ID
import com.app.xpertgroup.ui.screens.components.utils.rememberDefaultInputState
import com.app.xpertgroup.ui.theme.LocalCustomColorsPalette


@Composable
fun BasicTextField(
    modifier: Modifier = Modifier,
    hintModifier: Modifier = Modifier,
    @StringRes hint: Int = R.string.label_hint,
    @StringRes label: Int = R.string.label,
    state: DefaultInputStateI = rememberDefaultInputState(),
    theme: DefaultInputTheme = defaultTheme(),
) {
    state.hint = state.hint.ifBlank { stringResource(id = hint) }
    state.label = if(label == R.string.label && state.label.isNotBlank()) state.label else stringResource(id = label)
    Column {
        Spacer(Modifier.height(ConstantsValuesDp.value_dp_5))
        BasicTextField(
            modifier = modifier
                .testTag(DEFAULT_INPUT_ID)
                .onFocusChanged {
                    state.isFocused = it.isFocused
                },
            cursorBrush = SolidColor(theme.tint?: LocalCustomColorsPalette.current.textPrimary),
            visualTransformation = VisualTransformation.None,
            value = state.text,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            onValueChange = { newText ->
                    state.onTextChanged(newText)
            },
            decorationBox = { innerTextField ->
                DecorationBoxBasicTextField(
                    innerTextField = innerTextField,
                    state = state,
                    theme = DefaultInputTheme(tint = theme.tint),
                )
            },
            interactionSource = state.interactionSource,
            readOnly = state.readOnly,
            singleLine = true,
            textStyle = theme.textStyle,
        )
        HintInputField(
            state = state,
            modifier = hintModifier,
            theme = theme,
        )
    }
}