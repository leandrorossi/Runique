package com.leandrour.core.data.di

import com.leandrour.core.data.auth.EncryptedSessionStorage
import com.leandrour.core.data.networking.HttpClientFactory
import com.leandrour.core.data.run.OfflineFirstRunRepository
import com.leandrour.core.domain.SessionStorage
import com.leandrour.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}