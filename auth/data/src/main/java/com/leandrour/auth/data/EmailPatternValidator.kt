package com.leandrour.auth.data

import android.util.Patterns
import com.leandrour.auth.domain.PatternValidator

object EmailPatternValidator : PatternValidator {

    override fun matcher(value: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }
}