package com.app.xpertgroup.ui.screens.components.foundation

import com.app.xpertgroup.R

data class CustomIcon (
    var cancel: Int = R.drawable.icon_cancel,
    var checkCircleFilled: Int = R.drawable.icon_checkcirclefilled,
    var errorFilled: Int = R.drawable.icon_errorfilled,
)

val CustomIconDark = CustomIcon(
    cancel = R.drawable.icon_cancel_dark,
    checkCircleFilled = R.drawable.icon_checkcirclefilled_dark,
    errorFilled = R.drawable.icon_errorfilled_dark,
)

val CustomIconLight = CustomIcon(
    cancel = R.drawable.icon_cancel,
    checkCircleFilled = R.drawable.icon_checkcirclefilled,
    errorFilled = R.drawable.icon_errorfilled,
)

fun getCustomIconBasedOnTheme(isDarkTheme: Boolean): CustomIcon {
    return if (isDarkTheme) {
        CustomIconDark
    } else {
        CustomIconLight
    }
}