package com.leandrour.core.data.networking

data class AccessTokenRequest(
    val refreshToken: String,
    val userId: String
)
