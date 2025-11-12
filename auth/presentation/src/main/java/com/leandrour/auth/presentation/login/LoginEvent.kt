package com.leandrour.auth.presentation.login

import com.leandrour.core.presentation.ui.UiText

sealed interface LoginEvent {
    data class Error(val error: UiText): LoginEvent
    data object LoginSuccess : LoginEvent
}