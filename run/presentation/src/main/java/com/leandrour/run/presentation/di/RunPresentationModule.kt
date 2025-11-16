package com.leandrour.run.presentation.di

import com.leandrour.run.domain.RunningTracker
import com.leandrour.run.presentation.active_run.ActiveRunViewModel
import com.leandrour.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    singleOf(::RunningTracker)
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}