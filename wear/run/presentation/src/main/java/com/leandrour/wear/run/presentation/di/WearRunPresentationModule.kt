package com.leandrour.wear.run.presentation.di

import com.leandrour.wear.run.presentation.TrackerViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val wearRunPresentationModule = module {
    singleOf(::TrackerViewModel)
}