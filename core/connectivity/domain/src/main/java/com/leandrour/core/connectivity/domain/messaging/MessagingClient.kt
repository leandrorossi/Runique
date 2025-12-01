package com.leandrour.core.connectivity.domain.messaging

import com.leandrour.core.domain.util.EmptyDataResult
import kotlinx.coroutines.flow.Flow

interface MessagingClient {
    fun connectToNode(nodeId: String): Flow<MessagingAction>
    suspend fun sendOrQueueAction(action: MessagingAction): EmptyDataResult<MessagingError>
}