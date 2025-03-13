package com.app.xpertgroup.ui.screens.components.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import com.app.xpertgroup.ui.screens.components.inputs.DefaultInputStateImp
import com.app.xpertgroup.ui.screens.components.empty.EmptyComponentMessageImp

const val DEFAULT_INPUT_IS_FOCUSED_INDEX = 0
const val DEFAULT_INPUT_TEXT_INDEX = 1
const val DEFAULT_INPUT_ON_TEXT_CHANGED_INDEX = 2
const val DEFAULT_INPUT_LABEL_INDEX = 3
const val DEFAULT_INPUT_HINT_INDEX = 4
const val DEFAULT_INPUT_SHOW_HINT_INDEX = 5
const val DEFAULT_INPUT_SHOW_ERROR_INDEX = 6
const val DEFAULT_INPUT_SHOW_SUCCESS_INDEX = 7
const val DEFAULT_INPUT_ICON_INDEX = 8
const val DEFAULT_INPUT_TEXT_AREA_PLACEHOLDER_INDEX = 9
const val DEFAULT_INPUT_ICON_CLICK_INDEX = 10
const val DEFAULT_INPUT_TYPE_INDEX = 11
const val DEFAULT_INPUT_FOCUSABLE = 12
const val DEFAULT_INPUT_HIDE_IS_NOT_FOCUS = 13
const val DEFAULT_INPUT_KEYBOARD_OPTIONS = 14
const val DEFAULT_INPUT_INTERACTION_SOURCE = 15
const val DEFAULT_COUNTRY_CODE_INDEX = 16
const val DROPDOWN_CAN_EXPANDED_CODE_INDEX = 17
const val DEFAULT_INPUT_PREFIX = 18


const val EMPTY_VIEW_TITLE = 0
const val EMPTY_VIEW_SUB_TITLE = 1
const val EMPTY_VIEW_BUTTON_TITLE = 2
const val EMPTY_VIEW_BUTTON_SECONDARY_TITLE = 3
const val EMPTY_VIEW_SHOW_BUTTON = 4
const val EMPTY_VIEW_SECONDARY_SHOW_BUTTON = 5
const val EMPTY_VIEW_SECONDARY_DONE_BUTTON = 6
const val EMPTY_VIEW_DONE_BUTTON = 7

const val FILLED_INPUT_ID = "filled_field"
const val DEFAULT_INPUT_ID = "input_field"
const val TEXT_DECORATION_BOX = "text_decoration_box"
const val DEFAULT_BUTTON_ICON_ID = "default_button_icon"
const val EMPTY_CARD_USERS = "empty_cards_users"

object NodeTags {
    const val START_SCREEN_ROOT_TAG = "START_SCREEN_ROOT_TAG"

}
@Composable
fun rememberDefaultInputState() = rememberSaveable(
    saver = DefaultInputStateImp.Saver
) { DefaultInputStateImp() }

@Composable
fun rememberEmptyComponentState() = rememberSaveable(
    saver = EmptyComponentMessageImp.Saver
) { EmptyComponentMessageImp() }


inline fun <reified T : Any> Any?.checkType(): T? = if (this is T) this
else null
