package com.app.xpertgroup.ui.screens.components.empty

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue
import com.app.xpertgroup.ui.screens.components.utils.EMPTY_VIEW_BUTTON_SECONDARY_TITLE
import com.app.xpertgroup.ui.screens.components.utils.EMPTY_VIEW_BUTTON_TITLE
import com.app.xpertgroup.ui.screens.components.utils.EMPTY_VIEW_DONE_BUTTON
import com.app.xpertgroup.ui.screens.components.utils.EMPTY_VIEW_SECONDARY_DONE_BUTTON
import com.app.xpertgroup.ui.screens.components.utils.EMPTY_VIEW_SECONDARY_SHOW_BUTTON
import com.app.xpertgroup.ui.screens.components.utils.EMPTY_VIEW_SHOW_BUTTON
import com.app.xpertgroup.ui.screens.components.utils.EMPTY_VIEW_SUB_TITLE
import com.app.xpertgroup.ui.screens.components.utils.EMPTY_VIEW_TITLE
import com.app.xpertgroup.ui.screens.components.utils.checkType

class EmptyComponentMessageImp(
    title: String = "title",
    subTitle: String = "messageHere",
    buttonTitle: String = "Button",
    buttonSecondaryTitle: String = "Button",
    showButton: Boolean = false,
    showSecondaryButton: Boolean = false,
    buttonSecondaryAction: () -> Unit = {},
    buttonAction: () -> Unit = {},
) : EmptyMessageState {

    override var title: String by mutableStateOf(title)
    override var subTitle: String by mutableStateOf(subTitle)
    override var buttonTitle: String by mutableStateOf(buttonTitle)
    override var buttonSecondaryTitle: String by mutableStateOf(buttonSecondaryTitle)
    override var showButton: Boolean by mutableStateOf(showButton)
    override var showSecondaryButton: Boolean by mutableStateOf(showSecondaryButton)
    override var buttonSecondaryAction: () -> Unit by mutableStateOf(buttonSecondaryAction)
    override var buttonAction: () -> Unit by mutableStateOf(buttonAction)
    companion object {
        val Saver = Saver<EmptyComponentMessageImp, List<Any>>(save = {
            listOf(
                it.title,
                it.subTitle,
                it.buttonTitle,
                it.buttonSecondaryTitle,
                it.showButton,
                it.showSecondaryButton,
                it.buttonSecondaryAction,
                it.buttonAction,
            )
        },
            restore = { restore(it) })

        private fun restore(it: List<Any>): EmptyComponentMessageImp {
            return EmptyComponentMessageImp(
                it[EMPTY_VIEW_TITLE] as String,
                it[EMPTY_VIEW_SUB_TITLE] as String,
                it[EMPTY_VIEW_BUTTON_TITLE] as String,
                it[EMPTY_VIEW_BUTTON_SECONDARY_TITLE] as String,
                it[EMPTY_VIEW_SHOW_BUTTON] as Boolean,
                it[EMPTY_VIEW_SECONDARY_SHOW_BUTTON] as Boolean,
                it[EMPTY_VIEW_SECONDARY_DONE_BUTTON].checkType<() -> Unit>() as () -> Unit,
                it[EMPTY_VIEW_DONE_BUTTON].checkType<() -> Unit>() as () -> Unit,

            )
        }
    }
}