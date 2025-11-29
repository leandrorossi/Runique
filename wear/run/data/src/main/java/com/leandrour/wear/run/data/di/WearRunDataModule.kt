package com.leandrour.wear.run.data.di

import com.leandrour.wear.run.data.HealthServicesExerciseTracker
import com.leandrour.wear.run.data.WatchToPhoneConnector
import com.leandrour.wear.run.domain.ExerciseTracker
import com.leandrour.wear.run.domain.PhoneConnector
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val wearRunDataModule = module {
    singleOf(::HealthServicesExerciseTracker).bind<ExerciseTracker>()
    singleOf(::WatchToPhoneConnector).bind<PhoneConnector>()
}