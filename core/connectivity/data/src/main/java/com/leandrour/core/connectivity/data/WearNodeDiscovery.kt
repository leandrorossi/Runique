package com.leandrour.core.connectivity.data

import android.content.Context
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.wearable.CapabilityClient
import com.google.android.gms.wearable.CapabilityInfo
import com.google.android.gms.wearable.Wearable
import com.leandrour.core.connectivity.domain.DeviceNode
import com.leandrour.core.connectivity.domain.DeviceType
import com.leandrour.core.connectivity.domain.NodeDiscovery
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class WearNodeDiscovery(
    private val context: Context
) : NodeDiscovery {

    private val capabilityClient = Wearable.getCapabilityClient(context)

    override fun observeConnectedDevices(localDeviceType: DeviceType): Flow<Set<DeviceNode>> {
        return callbackFlow {
            val remoteCapabitity = when (localDeviceType) {
                DeviceType.PHONE -> "runique_wear_app"
                DeviceType.WATCH -> "runique_phone_app"
            }

            try {
                val capability = capabilityClient
                    .getCapability(remoteCapabitity, CapabilityClient.FILTER_REACHABLE)
                    .await()

                val connectedDevices = capability.nodes.map { it.toDeviceNode() }.toSet()
                send(connectedDevices)
            } catch (e: ApiException) {
                awaitClose()
                return@callbackFlow
            }

            val listener: (CapabilityInfo) -> Unit = {
                trySend(it.nodes.map { it.toDeviceNode() }.toSet())
            }
            capabilityClient.addListener(listener, remoteCapabitity)

            awaitClose {
                capabilityClient.removeListener(listener)
            }
        }
    }
}