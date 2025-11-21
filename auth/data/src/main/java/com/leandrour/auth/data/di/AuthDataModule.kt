package com.leandrour.auth.data.di

import com.leandrour.auth.data.AuthRepositoryImpl
import com.leandrour.auth.data.EmailPatternValidator
import com.leandrour.auth.domain.AuthRepository
import com.leandrour.auth.domain.PatternValidator
import com.leandrour.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}