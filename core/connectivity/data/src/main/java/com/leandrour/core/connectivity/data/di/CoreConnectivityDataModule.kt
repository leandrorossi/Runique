package com.leandrour.core.connectivity.data.di

import com.leandrour.core.connectivity.data.WearNodeDiscovery
import com.leandrour.core.connectivity.data.messaging.WearMessagingClient
import com.leandrour.core.connectivity.domain.NodeDiscovery
import com.leandrour.core.connectivity.domain.messaging.MessagingClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreConnectivityDataModule = module {
    singleOf(::WearNodeDiscovery).bind<NodeDiscovery>()
    singleOf(::WearMessagingClient).bind<MessagingClient>()
}