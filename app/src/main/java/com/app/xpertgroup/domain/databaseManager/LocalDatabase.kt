package com.app.xpertgroup.domain.databaseManager

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.xpertgroup.domain.daos.AddressDao
import com.app.xpertgroup.domain.daos.CompanyDao
import com.app.xpertgroup.domain.daos.GeoDao
import com.app.xpertgroup.domain.daos.UserDao
import com.app.xpertgroup.domain.databaseEntities.AddressDBEntity
import com.app.xpertgroup.domain.databaseEntities.CompanyDBEntity
import com.app.xpertgroup.domain.databaseEntities.GeoDBEntity
import com.app.xpertgroup.domain.databaseEntities.UserDBEntity

@Database(entities = [UserDBEntity::class, AddressDBEntity::class, CompanyDBEntity::class, GeoDBEntity::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun CompanyDao(): CompanyDao
    abstract fun GeoDao(): GeoDao
    abstract fun AddressDao(): AddressDao
    abstract fun UserDao(): UserDao
}