package com.app.xpertgroup.ui.screens.components.foundation

import androidx.compose.ui.graphics.Color


data class AppColorScheme(
    // Icon
    val iconPrimaryButton: Color = Color.Unspecified,
    val iconSecondaryButton: Color = Color.Unspecified,

    // Surface
    val surfacePrimaryButton: Color = Color.Unspecified,
    val surfaceSecondaryButton: Color = Color.Unspecified,

    val surfaceTertiary: Color = Color.Unspecified,
    val surfacePrimary: Color = Color.Unspecified,
    val surfaceSecondary: Color = Color.Unspecified,
    val surfaceFilled: Color = Color.Unspecified,


    // Text
    val textPrimaryButton: Color = Color.Unspecified,
    val textSecondaryButton: Color = Color.Unspecified,
    val textPrimary: Color = Color.Unspecified,
    val textSecondary: Color = Color.Unspecified,
    val textFormatedPrimary: Color = Color.Unspecified,
    val textError: Color = Color.Unspecified,
    val textSuccess: Color = Color.Unspecified,
    val textDisable: Color = Color.Unspecified,

    //Border
    val borderBold: Color = Color.Unspecified
)


val DarkThemeGenerated = AppColorScheme(
    borderBold = AppColors.white,
    surfacePrimary = AppColors.black,
    surfaceSecondary = AppColors.neutral50D,
    surfaceTertiary = AppColors.cyan400D,
    surfacePrimaryButton = AppColors.white,
    surfaceSecondaryButton = AppColors.black,
    textPrimary = AppColors.white,
    textSecondary = AppColors.neutral600D,
    textPrimaryButton = AppColors.black,
    textFormatedPrimary = AppColors.white,
    textSecondaryButton = AppColors.white,
    textError = AppColors.error500D,
    textSuccess = AppColors.success700D,
    textDisable = AppColors.neutral400D,
    iconPrimaryButton = AppColors.black,
    iconSecondaryButton = AppColors.white,
    surfaceFilled = AppColors.neutral50D,
)

val LightThemeGenerated = AppColorScheme(
    borderBold = AppColors.black,
    surfacePrimary = AppColors.white,
    surfaceSecondary = AppColors.neutral50L,
    surfaceTertiary = AppColors.cyan700L,
    surfacePrimaryButton = AppColors.black,
    surfaceSecondaryButton = AppColors.white,
    textPrimary = AppColors.black,
    textSecondary = AppColors.neutral600L,
    textPrimaryButton = AppColors.white,
    textFormatedPrimary = AppColors.white,
    textSecondaryButton = AppColors.black,
    textError = AppColors.error500L,
    textSuccess = AppColors.success700L,
    textDisable = AppColors.neutral400L,
    iconPrimaryButton = AppColors.white,
    iconSecondaryButton = AppColors.black,
    surfaceFilled = AppColors.neutral50L,
)

object AppColors {

    val cyan700L = Color(0xFF91A3A0)
    val cyan400D = Color(0xFF33524F)
    val white = Color(0xFFFFFFFF)
    // Gray
    val neutral50L = Color(0xFFF2F2F2)
    val neutral100L = Color(0xFFD7D7D7)
    val neutral400L = Color(0xFF979797)
    val neutral600L = Color(0xFF727272)
    val neutral50D = Color(0xFF191919)
    val neutral400D = Color(0xFF3A3A3A)
    val neutral600D = Color(0xFF606060)
    val black = Color(0xFF111111)
    val success700L = Color(0xFF5F9445)
    val success700D = Color(0xFF86D161)
    val error500L = Color(0xFFE23645)
    val error200D = Color(0xFFBF4549)
    val error500D = Color(0xFF8F3034)
}
