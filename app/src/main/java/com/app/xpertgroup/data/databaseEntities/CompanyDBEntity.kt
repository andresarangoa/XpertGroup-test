package com.app.xpertgroup.data.databaseEntities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "companies")
data class CompanyDBEntity(
    @PrimaryKey val name: String ="",
    val catchPhrase: String? = "",
    val bs: String? = ""
)