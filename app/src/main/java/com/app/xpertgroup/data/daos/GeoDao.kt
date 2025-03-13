package com.app.xpertgroup.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.app.xpertgroup.data.databaseEntities.GeoDBEntity

@Dao
interface GeoDao {
    // Returns the row ID of the inserted geo.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGeo(geo: GeoDBEntity): Long

    @Update
    suspend fun updateGeo(geo: GeoDBEntity)
}
