package com.leandrour.auth.presentation.register

import com.leandrour.core.presentation.ui.UiText

sealed interface RegisterEvent {
    data object RegistrationSuccess : RegisterEvent
    data class Error(val error: UiText): RegisterEvent
}