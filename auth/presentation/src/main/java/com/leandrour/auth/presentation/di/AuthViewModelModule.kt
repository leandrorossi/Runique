package com.leandrour.auth.presentation.di

import com.leandrour.auth.presentation.login.LoginViewModel
import com.leandrour.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}