package com.leandrour.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick : AnalyticsAction
}