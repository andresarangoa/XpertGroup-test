package com.app.xpertgroup.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.app.xpertgroup.data.local.databaseEntities.AddressDBEntity

@Dao
interface AddressDao {
    // Returns the row ID of the inserted address.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAddress(address: AddressDBEntity): Long

    @Update
    suspend fun updateAddress(address: AddressDBEntity)
}
