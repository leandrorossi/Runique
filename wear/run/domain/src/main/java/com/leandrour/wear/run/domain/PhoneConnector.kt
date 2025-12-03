package com.leandrour.wear.run.domain

import com.leandrour.core.connectivity.domain.DeviceNode
import com.leandrour.core.connectivity.domain.messaging.MessagingAction
import com.leandrour.core.connectivity.domain.messaging.MessagingError
import com.leandrour.core.domain.util.EmptyDataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface PhoneConnector {
    val connectedNode: StateFlow<DeviceNode?>
    val messagingActions: Flow<MessagingAction>

    suspend fun sendActionToPhone(action: MessagingAction): EmptyDataResult<MessagingError>
}