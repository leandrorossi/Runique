package com.leandrour.core.data.networking

data class AccessTokenResponse(
    val accessToken: String,
    val expirationTimestamp: Long
)
