package com.leandrour.auth.data

import com.leandrour.auth.domain.AuthRepository
import com.leandrour.core.data.networking.post
import com.leandrour.core.domain.util.DataError
import com.leandrour.core.domain.util.EmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient
) : AuthRepository {

    override suspend fun register(
        email: String,
        password: String
    ): EmptyDataResult<DataError.Network> {
        return httpClient.post(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}