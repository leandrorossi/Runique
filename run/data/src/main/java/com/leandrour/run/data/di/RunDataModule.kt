package com.leandrour.run.data.di

import com.leandrour.core.domain.run.SyncRunScheduler
import com.leandrour.run.data.CreateRunWorker
import com.leandrour.run.data.DeleteRunWorker
import com.leandrour.run.data.FetchRunsWorker
import com.leandrour.run.data.connectivity.PhoneToWatchConnector
import com.leandrour.run.data.SyncRunWorkerScheduler
import com.leandrour.run.domain.connectivity.WatchConnector
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::DeleteRunWorker)
    workerOf(::FetchRunsWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
    singleOf(::PhoneToWatchConnector).bind<WatchConnector>()
}