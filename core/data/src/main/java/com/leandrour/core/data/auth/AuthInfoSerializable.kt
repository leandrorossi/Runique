package com.leandrour.core.data.auth

data class AuthInfoSerializable(
    val accessToken: String,
    val refreshToken: String,
    val userId: String
)
