package com.leandrour.runique

import android.app.Application
import com.leandrour.auth.data.di.authDataModule
import com.leandrour.auth.presentation.BuildConfig
import com.leandrour.auth.presentation.di.authViewModelModule
import com.leandrour.core.data.di.coreDataModule
import com.leandrour.core.database.di.databaseModule
import com.leandrour.run.data.di.runDataModule
import com.leandrour.run.location.di.locationModule
import com.leandrour.run.network.di.networkModule
import com.leandrour.run.presentation.di.runPresentationModule
import com.leandrour.runique.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            workManagerFactory()

            modules(
                appModule,
                authDataModule,
                authViewModelModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }
}