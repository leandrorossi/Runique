package com.leandrour.run.domain.connectivity

import com.leandrour.core.connectivity.domain.DeviceNode
import com.leandrour.core.connectivity.domain.messaging.MessagingAction
import com.leandrour.core.connectivity.domain.messaging.MessagingError
import com.leandrour.core.domain.util.EmptyDataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface WatchConnector {
    val connectedDevice: StateFlow<DeviceNode?>
    val messagingActions: Flow<MessagingAction>

    suspend fun sendActionToWatch(action: MessagingAction): EmptyDataResult<MessagingError>
    fun setIsTrackable(isTrackable: Boolean)
}