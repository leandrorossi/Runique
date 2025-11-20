package com.leandrour.run.data.di

import com.leandrour.run.data.CreateRunWorker
import com.leandrour.run.data.DeleteRunWorker
import com.leandrour.run.data.FetchRunsWorker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::DeleteRunWorker)
    workerOf(::FetchRunsWorker)
}