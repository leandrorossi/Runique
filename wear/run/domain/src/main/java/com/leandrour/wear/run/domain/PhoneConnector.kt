package com.leandrour.wear.run.domain

import com.leandrour.core.connectivity.domain.DeviceNode
import kotlinx.coroutines.flow.StateFlow

interface PhoneConnector {
    val connectedNode: StateFlow<DeviceNode?>
}