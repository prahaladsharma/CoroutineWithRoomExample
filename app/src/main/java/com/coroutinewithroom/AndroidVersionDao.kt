package com.coroutinewithroom

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AndroidVersionDao {

    @Query("SELECT * FROM androidversions")
    suspend fun getAndroidVersion(): List<AndroidVersionEntity>

    /**
     * What to do if a conflict happens.
     * Use OnConflictStrategy.ABORT (default) to roll back the transaction on conflict.
     * Use OnConflictStrategy.REPLACE to replace the existing rows with the new rows.
     * Use OnConflictStrategy.IGNORE to keep the existing rows.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(androidVersionEntity: AndroidVersionEntity)

    @Query("DELETE FROM androidversions")
    suspend fun getClear()
}