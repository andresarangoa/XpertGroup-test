package com.app.xpertgroup.domain.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.xpertgroup.domain.databaseEntities.CompanyDBEntity

@Dao
interface CompanyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompany(company: CompanyDBEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompanies(companies: List<CompanyDBEntity>)

    @Query("SELECT * FROM companies")
    suspend fun getCompanies(): List<CompanyDBEntity>
}