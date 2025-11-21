package com.leandrour.auth.presentation.login

import androidx.compose.foundation.text.input.TextFieldState

data class LoginState(
    val email: TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState(),
    val isPasswordVisible: Boolean = false,
    val canLogging: Boolean = false,
    val isLoggingIn: Boolean = false
)
