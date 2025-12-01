package com.leandrour.core.connectivity.data.messaging

import com.leandrour.core.connectivity.domain.messaging.MessagingAction

fun MessagingAction.toMessagingActionDto(): MessagingActionDto {
    return when(this) {
        MessagingAction.ConnectionRequest -> MessagingActionDto.ConnectionRequest
        MessagingAction.Finish -> MessagingActionDto.Finish
        MessagingAction.Pause -> MessagingActionDto.Pause
        MessagingAction.StartOrResume -> MessagingActionDto.StartOrResume
        MessagingAction.Trackable -> MessagingActionDto.Trackable
        MessagingAction.Untrackable -> MessagingActionDto.Untrackable
        is MessagingAction.HeartRateUpdate -> MessagingActionDto.HeartRateUpdate(heartRate)
        is MessagingAction.DistanceUpdate -> MessagingActionDto.DistanceUpdate(distanceMeters)
        is MessagingAction.TimeUpdate -> MessagingActionDto.TimeUpdate(elapsedDuration)
    }
}

fun MessagingActionDto.toMessagingAction(): MessagingAction {
    return when(this) {
        MessagingActionDto.ConnectionRequest -> MessagingAction.ConnectionRequest
        MessagingActionDto.Finish -> MessagingAction.Finish
        MessagingActionDto.Pause -> MessagingAction.Pause
        MessagingActionDto.StartOrResume -> MessagingAction.StartOrResume
        MessagingActionDto.Trackable -> MessagingAction.Trackable
        MessagingActionDto.Untrackable -> MessagingAction.Untrackable
        is MessagingActionDto.HeartRateUpdate -> MessagingAction.HeartRateUpdate(heartRate)
        is MessagingActionDto.DistanceUpdate -> MessagingAction.DistanceUpdate(distanceMeters)
        is MessagingActionDto.TimeUpdate -> MessagingAction.TimeUpdate(elapsedDuration)
    }
}