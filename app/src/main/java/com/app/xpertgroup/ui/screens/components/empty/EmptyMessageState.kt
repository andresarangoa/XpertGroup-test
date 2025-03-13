package com.app.xpertgroup.ui.screens.components.empty

interface EmptyMessageState {
    var title: String
    var subTitle: String
    var buttonTitle: String
    var buttonSecondaryTitle: String
    var buttonAction: () -> Unit
    var buttonSecondaryAction: () -> Unit
    var showButton: Boolean
    var showSecondaryButton: Boolean
}