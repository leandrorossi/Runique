package com.leandrour.run.location

import android.location.Location
import com.leandrour.core.domain.location.LocationWithAltitude

fun Location.toLocationWithAltitude(): LocationWithAltitude {
    return LocationWithAltitude(
        location = com.leandrour.core.domain.location.Location(
            latitude = latitude,
            longitude = longitude,
        ),
        altitude = altitude
    )
}