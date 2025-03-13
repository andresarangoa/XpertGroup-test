package com.app.xpertgroup.domain.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.app.xpertgroup.domain.databaseEntities.AddressDBEntity

@Dao
interface AddressDao {
    // Returns the row ID of the inserted address.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAddress(address: AddressDBEntity): Long

    @Update
    suspend fun updateAddress(address: AddressDBEntity)
}
