package com.leandrour.core.connectivity.domain.messaging

import com.leandrour.core.domain.util.Error

enum class MessagingError : Error {
    CONNECTION_INTERRUPTED,
    DISCONNECTED,
    UNKNOWN
}