package com.leandrour.auth.domain

interface PatternValidator {
    fun matcher(value: String): Boolean
}