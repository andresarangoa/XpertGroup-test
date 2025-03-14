package com.app.xpertgroup.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.app.xpertgroup.data.local.databaseEntities.UserDBEntity
import com.app.xpertgroup.data.local.databaseEntities.UserFull

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserDBEntity)

    @Update
    suspend fun updateUser(user: UserDBEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserDBEntity>): List<Long>

    @Query("SELECT * FROM users")
    suspend fun getUsers(): List<UserDBEntity>

    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUserById(userId: Long): UserDBEntity?

    @Transaction
    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUserFullById(userId: Long): UserFull?

    @Transaction
    @Query("SELECT * FROM users")
    suspend fun getAllUsersFull(): List<UserFull>

    @Transaction
    @Query("SELECT * FROM users WHERE name LIKE '%' || :searchQuery || '%'")
    suspend fun getUsersByName(searchQuery: String): List<UserFull>
}