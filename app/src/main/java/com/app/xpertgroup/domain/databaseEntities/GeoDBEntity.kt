package com.app.xpertgroup.domain.databaseEntities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "geos")
data class GeoDBEntity(
    @PrimaryKey(autoGenerate = true) val geoId: Long = 0,
    val lat: String?,
    val lng: String?
)