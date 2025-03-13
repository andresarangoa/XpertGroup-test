package com.app.xpertgroup.ui.screens.components.userCard

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.app.xpertgroup.R
import com.app.xpertgroup.domain.modelDomain.UserDomain
import com.app.xpertgroup.ui.screens.components.foundation.AppColors
import com.app.xpertgroup.ui.screens.components.foundation.ConstantsValuesDp
import com.app.xpertgroup.ui.screens.components.foundation.ConstantsValuesSp
import com.app.xpertgroup.ui.theme.LocalCustomColorsPalette

@SuppressLint("ResourceType")
@Composable
fun UserCard(user: UserDomain) {
    Card(
        shape = RoundedCornerShape(ConstantsValuesDp.value_dp_12),
        elevation = CardDefaults.cardElevation(defaultElevation = ConstantsValuesDp.value_dp_8),
        colors = CardDefaults.cardColors(containerColor = LocalCustomColorsPalette.current.surfaceSecondary),
        modifier = Modifier
            .fillMaxWidth()
            .padding(ConstantsValuesDp.value_dp_8)
    ) {
        Row(
            modifier = Modifier.padding(ConstantsValuesDp.value_dp_16),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(ConstantsValuesDp.value_dp_48)
                    .clip(CircleShape)
                    .background(AppColors.neutral100L),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = user.name?.firstOrNull()?.toString() ?: "?",
                    style = TextStyle(
                        fontSize = ConstantsValuesSp.value_sp_20, fontWeight = FontWeight.Bold,
                        color = LocalCustomColorsPalette.current.textPrimaryButton
                    )
                )
            }

            Column(
                modifier = Modifier
                    .padding(horizontal = ConstantsValuesDp.value_dp_8)
            ) {
                Row {
                    Column(modifier = Modifier.weight(1f)) {
                        UserInfoItem(R.string.label_name, user.name)
                        UserInfoItem(R.string.label_user_name, user.userName)
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        UserInfoItem(R.string.label_email, user.email)
                        UserInfoItem(R.string.label_phone, user.phone)
                    }
                }

                UserInfoItem(R.string.label_website, user.website)
            }
        }
    }
}

@Preview
@Composable
fun PreviewUserCard() {
    val sampleUser = UserDomain(
        id = "1",
        name = "Leanne Graham",
        userName = null,
        email = "Sincere@april.biz",
        phone = "1-770-736-8031 x56442",
        website = "hildegard.org"
    )
    UserCard(user = sampleUser)
}
