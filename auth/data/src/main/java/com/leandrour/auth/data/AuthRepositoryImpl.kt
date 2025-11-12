package com.leandrour.auth.data

import com.leandrour.auth.domain.AuthRepository
import com.leandrour.core.data.networking.post
import com.leandrour.core.domain.AuthInfo
import com.leandrour.core.domain.SessionStorage
import com.leandrour.core.domain.util.DataError
import com.leandrour.core.domain.util.EmptyDataResult
import com.leandrour.core.domain.util.Result
import com.leandrour.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
) : AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): EmptyDataResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )

        if (result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyDataResult()
    }

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