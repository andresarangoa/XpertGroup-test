package com.app.xpertgroup.ui.screens.components.inputs

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_IS_FOCUSED_INDEX
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_COUNTRY_CODE_INDEX
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_FOCUSABLE
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_HIDE_IS_NOT_FOCUS
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_HINT_INDEX
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_ICON_CLICK_INDEX
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_ICON_INDEX
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_INTERACTION_SOURCE
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_KEYBOARD_OPTIONS
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_LABEL_INDEX
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_ON_TEXT_CHANGED_INDEX
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_PREFIX
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_SHOW_ERROR_INDEX
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_SHOW_HINT_INDEX
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_SHOW_SUCCESS_INDEX
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_TEXT_INDEX
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_TYPE_INDEX
import com.app.xpertgroup.ui.screens.components.utils.DEFAULT_INPUT_TEXT_AREA_PLACEHOLDER_INDEX
import com.app.xpertgroup.ui.screens.components.utils.DROPDOWN_CAN_EXPANDED_CODE_INDEX
import com.app.xpertgroup.ui.screens.components.utils.checkType

class DefaultInputStateImp(
    isFocused: Boolean = false,
    text: String = "",
    onTextChanged: (text: String) -> Unit = {},
    hint: String = "",
    label: String = "",
    showHint: Boolean = false,
    showError: Boolean = false,
    showSuccess: Boolean = false,
    icon: Int? = null,
    placeholder: String = "",
    onIconClick: () -> Unit = {},
    inputType: InputTypes = InputTypes.TEXT,
    readOnly: Boolean = false,
    iconVisibility: IconVisibility = IconVisibility.ALWAYS,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    interactionSource: MutableInteractionSource = MutableInteractionSource(),
    defaultCountryCode: String = "US",
    canExpand: Boolean = true,
    prefix: String = ""
) : DefaultInputStateI {
    override var isFocused: Boolean by mutableStateOf(isFocused)
    override var text: String by mutableStateOf(text)
    override var onTextChanged: (text: String) -> Unit by mutableStateOf(onTextChanged)
    override var hint: String by mutableStateOf(hint)
    override var label: String by mutableStateOf(label)
    override var showHint: Boolean by mutableStateOf(showHint)
    override var showError: Boolean by mutableStateOf(showError)
    override var showSuccess: Boolean by mutableStateOf(showSuccess)
    override var icon: Int? by mutableStateOf(icon)
    override var placeholder: String by mutableStateOf(placeholder)
    override var onIconClick: () -> Unit by mutableStateOf(onIconClick)
    override var inputType: InputTypes by mutableStateOf(inputType)
    override var readOnly: Boolean by mutableStateOf(readOnly)
    override var iconVisibility: IconVisibility by mutableStateOf(iconVisibility)
    override var keyboardOptions: KeyboardOptions by mutableStateOf(keyboardOptions)
    override var interactionSource: MutableInteractionSource by mutableStateOf(interactionSource)
    override var defaultCountryCode: String by mutableStateOf(defaultCountryCode)
    override var canExpand: Boolean by mutableStateOf(canExpand)
    override var prefix: String by mutableStateOf(prefix)

    override fun isValid(): Boolean = text.isNotEmpty()

    internal companion object {
        val Saver = Saver<DefaultInputStateImp, List<Any?>>(save = {
            listOf(
                it.isFocused,
                it.text,
                it.onTextChanged,
                it.hint,
                it.label,
                it.showHint,
                it.showError,
                it.showSuccess,
                it.icon,
                it.placeholder,
                it.onIconClick,
                it.inputType,
                it.readOnly,
                it.iconVisibility,
                it.keyboardOptions,
                it.interactionSource,
                it.defaultCountryCode,
                it.canExpand,
                it.prefix
            )
        },
            restore = { restore(it) })

        private fun restore(it: List<Any?>): DefaultInputStateImp {
            return DefaultInputStateImp(
                it[DEFAULT_INPUT_IS_FOCUSED_INDEX] as Boolean,
                it[DEFAULT_INPUT_TEXT_INDEX] as String,
                it[DEFAULT_INPUT_ON_TEXT_CHANGED_INDEX].checkType<(text: String) -> Unit>() as (text: String) -> Unit,
                it[DEFAULT_INPUT_LABEL_INDEX] as String,
                it[DEFAULT_INPUT_HINT_INDEX] as String,
                it[DEFAULT_INPUT_SHOW_HINT_INDEX] as Boolean,
                it[DEFAULT_INPUT_SHOW_ERROR_INDEX] as Boolean,
                it[DEFAULT_INPUT_SHOW_SUCCESS_INDEX] as Boolean,
                it[DEFAULT_INPUT_ICON_INDEX] as Int?,
                it[DEFAULT_INPUT_TEXT_AREA_PLACEHOLDER_INDEX] as String,
                it[DEFAULT_INPUT_ICON_CLICK_INDEX].checkType<() -> Unit>() as () -> Unit,
                it[DEFAULT_INPUT_TYPE_INDEX] as InputTypes,
                it[DEFAULT_INPUT_FOCUSABLE] as Boolean,
                it[DEFAULT_INPUT_HIDE_IS_NOT_FOCUS] as IconVisibility,
                it[DEFAULT_INPUT_KEYBOARD_OPTIONS] as KeyboardOptions,
                it[DEFAULT_INPUT_INTERACTION_SOURCE] as MutableInteractionSource,
                it[DEFAULT_COUNTRY_CODE_INDEX] as String,
                it[DROPDOWN_CAN_EXPANDED_CODE_INDEX] as Boolean,
                it[DEFAULT_INPUT_PREFIX] as String,
            )
        }
    }
}

enum class IconVisibility {
    ALWAYS,
    ONLY_WHEN_FOCUSED,
    FOCUSED_AND_NOT_EMPTY,
    FOCUSED_OR_NOT_EMPTY
}
interface DefaultInputStateI {
    var isFocused: Boolean
    var iconVisibility: IconVisibility
    var text: String
    var onTextChanged: (text: String) -> Unit
    var hint: String
    var label: String
    var showHint: Boolean
    var showError: Boolean
    var showSuccess: Boolean
    var icon: Int?
    var onIconClick: () -> Unit
    var inputType: InputTypes
    var placeholder: String
    var readOnly: Boolean
    var keyboardOptions: KeyboardOptions
    var interactionSource: MutableInteractionSource
    var defaultCountryCode: String
    var canExpand: Boolean
    var prefix: String
    fun isValid(): Boolean
}

enum class InputTypes {
     TEXT
}