package com.leandrour.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leandrour.core.database.dao.RunDao
import com.leandrour.core.database.dao.RunPendingSyncDao
import com.leandrour.core.database.entity.DeletedRunSyncEntity
import com.leandrour.core.database.entity.RunEntity
import com.leandrour.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
}