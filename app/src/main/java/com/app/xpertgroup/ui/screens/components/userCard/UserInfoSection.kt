package com.app.xpertgroup.ui.screens.components.userCard

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.app.xpertgroup.ui.screens.components.foundation.ConstantsValuesDp

@Composable
fun UserInfoItem(@StringRes labelRes: Int, value: String?) {
    if (!value.isNullOrEmpty()) {
        Text(
            text = stringResource(labelRes),
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.width(ConstantsValuesDp.value_dp_4))
        Text(text = value, style = MaterialTheme.typography.labelSmall)
    }
}