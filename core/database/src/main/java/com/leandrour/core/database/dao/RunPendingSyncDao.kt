package com.leandrour.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.leandrour.core.database.entity.DeletedRunSyncEntity
import com.leandrour.core.database.entity.RunPendingSyncEntity
import com.leandrour.core.domain.run.RunId

@Dao
interface RunPendingSyncDao {

    @Query("SELECT * FROM runpendingsyncentity WHERE userId = :userId")
    suspend fun getAllRunPendingSyncEntities(userId: String): List<RunPendingSyncEntity>

    @Query("SELECT * FROM runpendingsyncentity WHERE runId = :runId")
    suspend fun getRunPendingSyncEntity(runId: RunId): RunPendingSyncEntity?

    @Upsert
    suspend fun upsertRunPendingSyncEntity(entity: RunPendingSyncEntity)

    @Query("DELETE FROM runpendingsyncentity WHERE runId = :runId")
    suspend fun deleteRunPendingSyncEntity(runId: RunId)


    @Query("SELECT * FROM deletedrunsyncentity WHERE userId = :userId")
    suspend fun getAllDeleteRunSyncEntities(userId: String): List<DeletedRunSyncEntity>

    @Upsert
    suspend fun upsertDeleteRunSyncEntity(entity: DeletedRunSyncEntity)

    @Query("DELETE FROM deletedrunsyncentity WHERE runId = :runId")
    suspend fun deleteDeleteRunSyncEntity(runId: RunId)
}