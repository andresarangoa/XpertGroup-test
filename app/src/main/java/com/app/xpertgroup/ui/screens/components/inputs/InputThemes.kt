package com.app.xpertgroup.ui.screens.components.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.xpertgroup.ui.screens.components.foundation.AppColorScheme
import com.app.xpertgroup.ui.screens.components.foundation.AppColors
import com.app.xpertgroup.ui.screens.components.foundation.ConstantsValuesDp
import com.app.xpertgroup.ui.screens.components.foundation.CustomIcon
import com.app.xpertgroup.ui.screens.components.foundation.RobotoTypography
import com.app.xpertgroup.ui.screens.components.foundation.Size
import com.app.xpertgroup.ui.screens.components.foundation.getCustomIconBasedOnTheme
import com.app.xpertgroup.ui.screens.components.inputs.basic.IconTheme
import com.app.xpertgroup.ui.theme.LocalCustomColorsPalette

data class DefaultInputTheme(
    var tint: Color? = Color.Gray,
    var textStyle: TextStyle = TextStyle(),
    var prefixTextStyle: TextStyle = TextStyle(),
    var borderColorFocused: Color = Color.Gray,
    var borderColor: Color = Color.Gray,
    var borderSizeFocused: Dp = 2.dp,
    var borderSize: Dp = 1.dp,
    var fontSize: TextUnit = 10.sp,
    var modifier: Modifier = Modifier,
    var hintModifier: Modifier = Modifier,
    var iconSuccess: Int = CustomIcon().checkCircleFilled,
    var iconError: Int = CustomIcon().errorFilled,
    var iconSuccessColor: Color = AppColors.success700L,
    var iconErrorColor: Color = AppColors.error200D,
    var background: Color = AppColors.white,
    var visualTransformation: VisualTransformation = VisualTransformation.None,
    var height: Dp = 55.dp
)

@Composable
fun defaultTheme(
    customColors: ProvidableCompositionLocal<AppColorScheme> = LocalCustomColorsPalette
) = DefaultInputTheme(
    borderColor = customColors.current.borderBold,
    borderColorFocused = customColors.current.borderBold,
    iconSuccess = getCustomIconBasedOnTheme(isSystemInDarkTheme()).checkCircleFilled,
    iconError = getCustomIconBasedOnTheme(isSystemInDarkTheme()).errorFilled,
    iconErrorColor = customColors.current.textError,
    iconSuccessColor = customColors.current.textSuccess,
    modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 4.dp)
        .fillMaxWidth()
        .height(55.dp)
        .clip(shape = MaterialTheme.shapes.small)
        .background(customColors.current.surfacePrimary),
    hintModifier = Modifier.padding(
        horizontal = 16.dp, vertical = 4.dp
    ),
    textStyle = RobotoTypography.bodyMedium.copy(color = customColors.current.textPrimary),
    tint = customColors.current.borderBold
)

@Composable
fun filledTheme(
    customColors: ProvidableCompositionLocal<AppColorScheme> = LocalCustomColorsPalette
) = DefaultInputTheme(
    modifier = Modifier.defaultModifierFilledTheme(),
    iconErrorColor = customColors.current.textError,
    iconSuccess = getCustomIconBasedOnTheme(isSystemInDarkTheme()).checkCircleFilled,
    iconError = getCustomIconBasedOnTheme(isSystemInDarkTheme()).errorFilled,
    iconSuccessColor = customColors.current.textSuccess,
    hintModifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
)

@Composable
fun Modifier.defaultModifierFilledTheme(
    customColors: ProvidableCompositionLocal<AppColorScheme> = LocalCustomColorsPalette
): Modifier = this
    .padding(horizontal = 16.dp, vertical = 4.dp)
    .clip(shape = ShapeDefaults.Small)
    .background(customColors.current.surfaceFilled)
    .fillMaxWidth()

@Composable
fun Modifier.modifierDecorationBoxBasic(state: DefaultInputStateI): Modifier {
    return this.then(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(getSpacingWithIcon(state))
            .padding(start = ConstantsValuesDp.value_dp_8)
    )
}
@Composable
fun getSpacingWithIcon(state: DefaultInputStateI): Float = if (state.icon != null) 0.9f else 1f

fun DefaultInputStateI.isLabelVisible() = (this.isFocused || this.text.isNotEmpty())

fun DefaultInputStateI.shouldShowIcon(): Boolean {
    return when (this.iconVisibility) {
        IconVisibility.ALWAYS -> true
        IconVisibility.ONLY_WHEN_FOCUSED -> this.isFocused
        IconVisibility.FOCUSED_OR_NOT_EMPTY -> this.isFocused || (!this.isFocused && this.text.isNotEmpty())
        IconVisibility.FOCUSED_AND_NOT_EMPTY -> this.isFocused && this.text.isNotEmpty()
    }
}

@Composable
fun DefaultInputTheme.getHintTextColor(state: DefaultInputStateI): Color =
    if (state.showSuccess || state.showError) this.getHintStateColor(state = state) else this.tint
        ?: Color.Gray

@Composable
fun DefaultInputTheme.getHintStateColor(state: DefaultInputStateI): Color =
    if (state.showSuccess) this.iconSuccessColor else this.iconErrorColor

@Composable
fun DefaultInputTheme.getHintStateIcon(state: DefaultInputStateI): Int =
    if (state.showSuccess) this.iconSuccess else this.iconError

@Composable
fun IconTheme.getTintColor(isEnable: Boolean): Color =
    if (isEnable) this.tint?: LocalCustomColorsPalette.current.textPrimaryButton else this.disableTint?: LocalCustomColorsPalette.current.textDisable

@Composable
fun Modifier.getIconDefaultSize(): Modifier = this.then(Modifier.size(Size.primaryButtonIcon))