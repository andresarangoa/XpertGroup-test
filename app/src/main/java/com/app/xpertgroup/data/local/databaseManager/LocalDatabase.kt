package com.app.xpertgroup.data.local.databaseManager

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.xpertgroup.data.local.daos.AddressDao
import com.app.xpertgroup.data.local.daos.CompanyDao
import com.app.xpertgroup.data.local.daos.GeoDao
import com.app.xpertgroup.data.local.daos.UserDao
import com.app.xpertgroup.data.local.databaseEntities.AddressDBEntity
import com.app.xpertgroup.data.local.databaseEntities.CompanyDBEntity
import com.app.xpertgroup.data.local.databaseEntities.GeoDBEntity
import com.app.xpertgroup.data.local.databaseEntities.UserDBEntity

@Database(entities = [UserDBEntity::class, AddressDBEntity::class, CompanyDBEntity::class, GeoDBEntity::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun CompanyDao(): CompanyDao
    abstract fun GeoDao(): GeoDao
    abstract fun AddressDao(): AddressDao
    abstract fun UserDao(): UserDao
}