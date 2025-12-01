@file:OptIn(ExperimentalCoroutinesApi::class)

package com.leandrour.wear.run.data

import com.leandrour.core.connectivity.domain.DeviceNode
import com.leandrour.core.connectivity.domain.DeviceType
import com.leandrour.core.connectivity.domain.NodeDiscovery
import com.leandrour.core.connectivity.domain.messaging.MessagingAction
import com.leandrour.core.connectivity.domain.messaging.MessagingClient
import com.leandrour.core.connectivity.domain.messaging.MessagingError
import com.leandrour.core.domain.util.EmptyDataResult
import com.leandrour.wear.run.domain.PhoneConnector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.shareIn

class WatchToPhoneConnector(
    nodeDiscovery: NodeDiscovery,
    applicationScope: CoroutineScope,
    private val messagingClient: MessagingClient
) : PhoneConnector {

    private val _connectedNode = MutableStateFlow<DeviceNode?>(null)
    override val connectedNode = _connectedNode.asStateFlow()

    override val messagingActions: Flow<MessagingAction> = nodeDiscovery
        .observeConnectedDevices(DeviceType.WATCH)
        .flatMapLatest { connectedNodes ->
            val node = connectedNodes.firstOrNull()
            if (node != null && node.isNearby) {
                _connectedNode.value = node
                messagingClient.connectToNode(node.id)
            } else flowOf()
        }
        .shareIn(
            applicationScope,
            SharingStarted.Eagerly
        )

    override suspend fun sendActionToPhone(action: MessagingAction): EmptyDataResult<MessagingError> {
        return messagingClient.sendOrQueueAction(action)
    }
}