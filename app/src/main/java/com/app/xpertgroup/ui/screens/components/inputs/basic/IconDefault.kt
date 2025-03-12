package com.app.xpertgroup.ui.screens.components.inputs.basic

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.app.xpertgroup.R
import com.app.xpertgroup.ui.screens.components.inputs.getIconDefaultSize
import com.app.xpertgroup.ui.screens.components.inputs.getTintColor
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_BUTTON_ICON_ID

@Composable
fun IconDefault(
    modifier: Modifier = Modifier,
    iconTheme: IconTheme? = IconTheme(),
    isEnable: Boolean = true,
) {
    iconTheme?.icon?.let {
        Icon(
            painter = painterResource(
                id = it
            ),
            tint = iconTheme.getTintColor(isEnable = isEnable),
            modifier = modifier.getIconDefaultSize().testTag(DEFAULT_BUTTON_ICON_ID),
            contentDescription = stringResource(id = R.string.label_hint)
        )
    }
}
