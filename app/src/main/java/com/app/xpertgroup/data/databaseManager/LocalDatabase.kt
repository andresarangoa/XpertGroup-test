package com.app.xpertgroup.data.databaseManager

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.xpertgroup.data.daos.AddressDao
import com.app.xpertgroup.data.daos.CompanyDao
import com.app.xpertgroup.data.daos.GeoDao
import com.app.xpertgroup.data.daos.UserDao
import com.app.xpertgroup.data.databaseEntities.AddressDBEntity
import com.app.xpertgroup.data.databaseEntities.CompanyDBEntity
import com.app.xpertgroup.data.databaseEntities.GeoDBEntity
import com.app.xpertgroup.data.databaseEntities.UserDBEntity

@Database(entities = [UserDBEntity::class, AddressDBEntity::class, CompanyDBEntity::class, GeoDBEntity::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun CompanyDao(): CompanyDao
    abstract fun GeoDao(): GeoDao
    abstract fun AddressDao(): AddressDao
    abstract fun UserDao(): UserDao
}