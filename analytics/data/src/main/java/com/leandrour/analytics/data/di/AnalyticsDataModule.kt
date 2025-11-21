package com.leandrour.analytics.data.di

import com.leandrour.analytics.data.RoomAnalyticsRepository
import com.leandrour.analytics.domain.AnalyticsRepository
import com.leandrour.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao
    }
}