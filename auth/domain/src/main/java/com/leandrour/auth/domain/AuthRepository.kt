package com.leandrour.auth.domain

import com.leandrour.core.domain.util.DataError
import com.leandrour.core.domain.util.EmptyDataResult

interface AuthRepository {
    suspend fun login(email: String, password: String): EmptyDataResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyDataResult<DataError.Network>
}