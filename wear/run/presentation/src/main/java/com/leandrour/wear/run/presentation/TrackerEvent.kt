package com.leandrour.wear.run.presentation

sealed interface TrackerEvent {
    data object RunFinished: TrackerEvent
}